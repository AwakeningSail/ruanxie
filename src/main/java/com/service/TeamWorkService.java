package com.service;

import com.Data.Team;
import com.Data.Teamwork;
import com.Data1.*;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mapper.StudentMapper;
import com.mapper.TeamMapper;
import com.mapper.TeamworkMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TeamWorkService {
    @Autowired(required=false)
    TeamMapper teamMapper;
    @Autowired(required=false)
    TeamworkMapper teamworkMapper;
    @Autowired(required=false)
    private StudentMapper studentMapper;
    SqlSession sqlSession ;
    TeamService teamService;
    DocumentService documentService;
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

    public TeamWorkService() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
        teamMapper=sqlSession.getMapper(com.mapper.TeamMapper.class);
        studentMapper=sqlSession.getMapper(com.mapper.StudentMapper.class);
        teamworkMapper=sqlSession.getMapper(com.mapper.TeamworkMapper.class);
        teamService=new TeamService();
        documentService=new DocumentService();
        status[0]="发布成功";
        status[1]="存在不属于团队的学生ID";
        status[2]="修改成功";
        status[3]="文件不存在";
        status[4]="该团队还未建立";
        status[5]="未加入到团队中";
        status[6]="作业不存在";
        status[7]="未给该同学分配任务";
        status[8]="修改分数成功";
    }

    public List<com.Data1.Teamwork>queryAllTeamWork(int TeamID){

        List<Teamwork> teamworks=teamworkMapper.getTeamworkById(TeamID);
        List<com.Data1.Teamwork>teamworks1=new ArrayList<>();
        for(Teamwork teamwork:teamworks){
            System.out.println(teamwork);
            System.out.println(new com.Data1.Teamwork(teamwork));
            teamworks1.add(new com.Data1.Teamwork(teamwork));
        }
        return teamworks1;
    }

    public int addTeamWork(int TeamID, List<WorkArrangement> workArrangementList) throws NoSuchFieldException, IllegalAccessException {
        System.out.println("addteamwork working");
        for(WorkArrangement workArrangement:workArrangementList){
            System.out.println(workArrangement);
        }
        System.out.println(workArrangementList);
        WorkArrangements workArrangements=new WorkArrangements(workArrangementList);
        System.out.println(workArrangements.getWorkArrangemnets());
        Team team=teamMapper.getTeamById(TeamID);
        if(!team.isBuild()){
            return 4;
        }
        com.Data1.Team team1=new com.Data1.Team(team);
        if(!teamService.checkTeamMember(workArrangements.getWorkArrangemnets(),team1)){
            return 1;
        }
        com.Data1.Teamwork teamwork=new com.Data1.Teamwork();
        teamwork.setTeamworkid(getMaxWorkID(TeamID));
        teamwork.setTeamID(TeamID);
        teamwork.setWorkArrangements(workArrangements);
        teamwork.setAssignmentResults(null);
        teamwork.setMeetingMinutes(0);
        System.out.println(teamwork);
        Teamwork teamwork1=new Teamwork(teamwork);
        System.out.println(teamwork1);
        teamworkMapper.addTeamwork(teamwork1);
        sqlSession.commit();
        return 0;
    }
    private int getMaxWorkID(int TeamID){
        List<Teamwork> teamworks=teamworkMapper.getTeamworkById(TeamID);
        int ans=0;
        for(Teamwork teamwork:teamworks){
            ans=Math.max(ans,teamwork.getTeamworkid());
        }
        return ans+1;
    }

    public int updateTeamAssignmentResults(int TeamID,String studentID,int TeamworkID,int DocumentID){
        if(!documentService.check(DocumentID)){
            return 3;
        }
        Teamwork teamwork = teamworkMapper.getTeamworkByID1(TeamworkID,TeamID);
        if(teamwork==null){
            return 6;
        }
        com.Data1.Teamwork teamwork1=new com.Data1.Teamwork(teamwork);
        System.out.println(teamwork1);
        boolean b=false;
        for(WorkArrangement workArrangement:teamwork1.getWorkArrangements().getWorkArrangemnets()){
            if(studentID.equals(workArrangement.getStudentID())){
                b=true;
                break;
            }
        }
        if(!b){
            return 7;
        }
        AssignmentResults assignmentResults;
        if(teamwork1==null){
            assignmentResults=new AssignmentResults();
        }else{
            assignmentResults=teamwork1.getAssignmentResults();
        }
        assignmentResults.setAssignmentResults(new AssignmentResult(studentID,DocumentID));
        teamwork1.setAssignmentResults(assignmentResults);
        System.out.println(teamwork1);
        teamwork=new Teamwork(teamwork1);
        teamworkMapper.updateTeamwork(teamwork);
        sqlSession.commit();
        return 2;
    }
    public int updateTeamWorkMeetingMinutes(int TeamworkID,int TeamID,int DocumentID){
        if(!documentService.check(DocumentID)){
            return 3;
        }
        Teamwork teamwork = teamworkMapper.getTeamworkByID1(TeamworkID,TeamID);
        teamwork.setMeetingMinutes(DocumentID);
        teamworkMapper.updateTeamwork(teamwork);
        sqlSession.commit();
        return 2;
    }
    public int updateScores(int TeamID,String studentID,int TeamworkID,int score){
        Teamwork teamwork = teamworkMapper.getTeamworkByID1(TeamworkID,TeamID);
        com.Data1.Teamwork teamwork1=new com.Data1.Teamwork(teamwork);
        boolean b=false;
        for(WorkArrangement workArrangement:teamwork1.getWorkArrangements().getWorkArrangemnets()){
            if(studentID.equals(workArrangement.getStudentID())){
                b=true;
                break;
            }
        }
        if(!b){
            return 7;
        }
        TeamScore score1=new TeamScore(studentID,score);
        teamwork1.getTeamScores().setTeamScores(score1);
        teamwork=new Teamwork(teamwork1);
        teamworkMapper.updateTeamwork(teamwork);
        System.out.println(JSONObject.toJSONString(teamwork1.getTeamScores()));
        System.out.println(teamwork);
        sqlSession.commit();
        return 8;
    }
}
