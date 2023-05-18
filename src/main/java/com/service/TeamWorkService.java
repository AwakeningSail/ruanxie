package com.service;

import com.Data.Team;
import com.Data.Teamwork;
import com.Data1.WorkArrangement;
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
        status[0]="发布成功";
        status[1]="存在不属于团队的学生ID";
    }

    public List<com.Data1.Teamwork>queryAllTeamWork(int TeamID){
        List<Teamwork> teamworks=teamworkMapper.getTeamworkById(TeamID);
        List<com.Data1.Teamwork>teamworks1=new ArrayList<>();
        for(Teamwork teamwork:teamworks){
            teamworks1.add(new com.Data1.Teamwork(teamwork));
        }
        return teamworks1;
    }

    public int addTeamWork(int TeamID, String jsonObject) throws NoSuchFieldException, IllegalAccessException {
        System.out.println("addteamwork working");
        System.out.println(jsonObject);
        Map map= (Map) JSON.parse(String.valueOf(jsonObject));
        System.out.println(map);
        WorkArrangement workArrangement=new WorkArrangement(map);
        System.out.println(workArrangement.getWorkArrangemnet());
        Team team=teamMapper.getTeamById(TeamID);
        com.Data1.Team team1=new com.Data1.Team(team);
        if(!teamService.checkTeamMember(map.keySet(),team1)){
            return 1;
        }
        com.Data1.Teamwork teamwork=new com.Data1.Teamwork();
        teamwork.setTeamworkid(getMaxWorkID(TeamID));
        teamwork.setTeamID(TeamID);
        teamwork.setWorkArrangement(workArrangement);
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
}
