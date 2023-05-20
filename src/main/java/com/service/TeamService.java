package com.service;

import com.Data.Student;
import com.Data.Team;
import com.Data1.Arrangement;
import com.Data1.StudentOccupation;
import com.Data1.WorkArrangement;
import com.Request.ArrangementRequest;
import com.alibaba.fastjson.JSONObject;
import com.mapper.StudentMapper;
import com.mapper.TeamMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.*;

public class TeamService  {
    @Autowired(required=false)
    TeamMapper teamMapper;
    @Autowired(required=false)
    private StudentMapper studentMapper;
    SqlSession sqlSession ;
    String[] status= new String[20];


    public String[] getStatus() {
        return status;
    }
    public String getStatus(int i) {
        return status[i];
    }
    public void setStatus(String[] status) {
        this.status = status;
    }

    public TeamService() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
        teamMapper=sqlSession.getMapper(com.mapper.TeamMapper.class);
        studentMapper=sqlSession.getMapper(com.mapper.StudentMapper.class);

        status[0]="团队职位配成功分！";
        status[1]="漏输入学生ID";
        status[2]="多输入学生ID";
        status[3]="错误输入学生ID";
        status[4]="团队ID错误";
        status[5]="加入成功";
        status[6]="当前团队已满";
    }
    public com.Data1.Team TeamBuild(Student student) throws IOException {
        int maxTeamId =getMaxTeamId();

        // 新团队的ID为当前所有团队ID的最大值加一
        int newTeamId = maxTeamId + 1;

        // 建立新团队
        student.setTeamID(newTeamId);
        com.Data1.Team newTeam = new com.Data1.Team();
        com.Data.Team team ;
        Arrangement arrangement=new Arrangement();
        newTeam.setTeamID(newTeamId);
        newTeam.setTeamSize(1);
        newTeam.setBuild(false);
        newTeam.setBuildTime(null);
        arrangement.setLeader(student);
        newTeam.setArrangement(arrangement);
        newTeam.setReplyScore(null);
        newTeam.setNotice(null);
        team=new Team(newTeam);
        teamMapper.addTeam(team);

        // 更新学生信息，将学生加入新团队
        studentMapper.updateStudent(student);
        sqlSession.commit();
        return newTeam;
    }
    int getMaxTeamId(){
        List<com.Data.Team> teams=queryAllTeam();
        int MaxTeamID=0;
        for(com.Data.Team i :teams){
            MaxTeamID=Math.max(MaxTeamID,i.getTeamID());
        }
        return MaxTeamID;
    }
    public List<com.Data.Team> queryAllTeam(){
        List<com.Data.Team> teams=teamMapper.getAllTeams();
        return teams;
    }

    public int joinTeam(int TeamID,String StudentID) throws IOException, NoSuchFieldException, IllegalAccessException {
        Team team=teamMapper.getTeamById(TeamID);
        Student student = studentMapper.getStudentById(StudentID);
        if(team.getTeamSize()==5){
            return 6;
        }
        student.setTeamID(team.getTeamID());
        team.setTeamSize(team.getTeamSize()+1);
        com.Data1.Team team1=new com.Data1.Team(team);
        System.out.println("team:"+team);
        String[] strings= {"leader", "productManager", "planQualityManager", "testManager", "devManager"};
        String s = null;
        Arrangement arrangement=team1.getArrangement();
        Class<?> clazz = arrangement.getClass();
        Field field ;
        for(String i :strings){
            field=clazz.getDeclaredField(i);
            field.setAccessible(true);
            Object object =field.get(team1.getArrangement());
            System.out.println(i+":"+object);
            if(object==null){
                s=i;
                break;
            }
        }
        field=clazz.getDeclaredField(s);
        field.setAccessible(true);
        field.set(arrangement,student);
        team1.setArrangement(arrangement);
        System.out.println("team1:"+team1);
        team=new Team(team1);
        System.out.println("team:"+team);
        teamMapper.updateTeam(team);
        studentMapper.updateStudent(student);
        sqlSession.commit();
        return 5;
    }

    public List<StudentOccupation>FindStudentOccupation(int teamID){
        Team team=teamMapper.getTeamById(teamID);
        com.Data1.Team team1=new com.Data1.Team(team);
        Arrangement arrangement=team1.getArrangement();
        List<StudentOccupation> studentOccupations=  new ArrayList<>();
        if(arrangement.getLeader()!=null)studentOccupations.add(
                new StudentOccupation(arrangement.getLeader(),"leader"));
        if(arrangement.getDevManager()!=null)studentOccupations.add(
                new StudentOccupation(arrangement.getDevManager(),"devManager"));
        if(arrangement.getPlanQualityManager()!=null)studentOccupations.add(
                new StudentOccupation(arrangement.getPlanQualityManager(),"planQualityManager"));
        if(arrangement.getTestManager()!=null)studentOccupations.add(
                new StudentOccupation(arrangement.getTestManager(),"testManager"));
        if(arrangement.getProductManager()!=null)studentOccupations.add(
                new StudentOccupation(arrangement.getProductManager(),"productManager"));
        return studentOccupations;
    }

    Arrangement FindTeamMemmber(ArrangementRequest arrangementRequest) throws NoSuchFieldException, IllegalAccessException {
        String[] strings= {"leader", "productManager", "planQualityManager", "testManager", "devManager"};
        String s = null;
        Arrangement arrangement=new Arrangement();
        Class<?> clazz = arrangementRequest.getClass();
        Class<?> clazz1= arrangement.getClass();
        Field field ,field1;
        for(String i :strings){
            field=clazz.getDeclaredField(i);
            field1=clazz1.getDeclaredField(i);
            field.setAccessible(true);
            Object object=field.get(arrangementRequest);
            if(object!=null){
                Student student = studentMapper.getStudentById((String) object);
                System.out.println("---------------------------------------------------");
                System.out.println(i);
                System.out.println(student);
                field1.setAccessible(true);
                field1.set(arrangement,student);
            }
        }
        return arrangement;
    }
    public int updateTeamArrangement(ArrangementRequest arrangementRequest,int TeamID) throws NoSuchFieldException, IllegalAccessException {
        Arrangement arrangement=FindTeamMemmber(arrangementRequest);
        Team team = teamMapper.getTeamById(TeamID);
        com.Data1.Team team1= new com.Data1.Team(team);
        int op=checkTeamMemebr(arrangement,team1.getArrangement());
        System.out.println(op);
        if(op==0){
                team1.setArrangement(arrangement);
                team=new Team(team1);
                teamMapper.updateTeam(team);
                sqlSession.commit();
        }
        return op;

    }
    int checkTeamMemebr(Arrangement arrangement,Arrangement arrangement1) throws NoSuchFieldException, IllegalAccessException {
        String[] strings2= {"leader", "productManager", "planQualityManager", "testManager", "devManager"};
        List<String> strings=new ArrayList<>();
        List<String>  strings1= new ArrayList<>();
        Field field;
        Class<?> clazz=arrangement.getClass();
        for(String i :strings2) {
            field = clazz.getDeclaredField(i);
            field.setAccessible(true);
            Student object= (Student) field.get(arrangement);
            if(object!=null){
                strings.add(object.getStudentID());
            }
        }
        Collections.sort(strings);
        clazz=arrangement1.getClass();
        for(String i :strings2) {
            field = clazz.getDeclaredField(i);
            field.setAccessible(true);
            Student object= (Student) field.get(arrangement1);
            if(object!=null){
                strings1.add(object.getStudentID());
            }
        }
        Collections.sort(strings1);
        System.out.println(strings);
        System.out.println(strings1);
        if(strings.size()<strings1.size())return 1;
        if(strings.size()>strings1.size())return 2;
        Iterator<String> iterator1=strings1.iterator();
        for(Iterator iterator = strings.iterator();iterator.hasNext()&&iterator1.hasNext();){
            if(!iterator.next().equals(iterator1.next())){
                return 3;
            }
        }
        return 0;
    }
    public void updateTeamisbuild(int TeamID){
        Team team = teamMapper.getTeamById(TeamID);
        team.setBuild(!team.isBuild());
        teamMapper.updateTeam(team);
        sqlSession.commit();
    }
    List<String>FindTeamMember(com.Data1.Team team) throws NoSuchFieldException, IllegalAccessException {
        List<String>list=new ArrayList<>();
        String[] strings= {"leader", "productManager", "planQualityManager", "testManager", "devManager"};
        Class<?> clazz = team.getArrangement().getClass();
        Field field ,field1;
        for(String i :strings){
            field=clazz.getDeclaredField(i);
            field.setAccessible(true);
            Student object=(Student) field.get(team.getArrangement());
            if(object!=null){
                list.add( object.getStudentID());
            }
        }
        return list;
    }
    public boolean checkTeamMember(List<WorkArrangement> workArrangements, com.Data1.Team team) throws NoSuchFieldException, IllegalAccessException {
        System.out.println("checkTeamMember working");
        Set<String>strings=new HashSet<>();
        for(WorkArrangement workArrangement:workArrangements){
            strings.add(workArrangement.getStudentID());
        }
        System.out.println(strings);
        List<String> strings1=this.FindTeamMember(team);
        System.out.println(strings1);
        for(String s:strings){
            boolean b=false;
            for(String s1:strings1)if(s.equals(s1)){
                b=true;
            }
            if(!b){
                return false;
            }
        }
        return true;
    }
   // List<Team>
}
