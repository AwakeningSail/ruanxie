package com.controller;

import com.Data.Team;
import com.Data1.Arrangement;
import com.Data1.JsonFactory;
import com.Data1.Teamwork;
import com.Request.AddTeamWorkArrangementRequest;
import com.Request.objectRequest;
import com.RuanxieApplication;
import com.alibaba.fastjson.JSON;
import com.service.StudentService;
import com.service.TeamService;
import com.service.TeamWorkService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@EnableSwagger2
@RequestMapping("/student/teamwork")
public class TeamWorkController {
    StudentService studentService;
    TeamWorkService teamWorkService;
    JsonFactory jsonFactory;
    @ApiOperation(value = "学生", notes = "获取任务信息")
    @PostMapping("/query")
    public ResponseEntity<List<Teamwork>> QueryTeamWork() throws IOException {

        teamWorkService = new TeamWorkService();
        jsonFactory = new JsonFactory();
        List<Teamwork> teamworks = teamWorkService.queryAllTeamWork(RuanxieApplication.maplog.FindTeamID());
        return ResponseEntity.ok(teamworks);
    }
    @ApiOperation(value = "学生", notes = "发布任务")
    @PostMapping("/add")
    public ResponseEntity<String> addTeamWork(@ApiParam("输入每位学生的ID和对应的任务介绍")@RequestParam Map<String,String> arrangement) throws IOException, NoSuchFieldException, IllegalAccessException {

        teamWorkService = new TeamWorkService();
        jsonFactory = new JsonFactory();
        System.out.println(arrangement);
        int op= teamWorkService.addTeamWork(RuanxieApplication.maplog.FindTeamID(), arrangement.get("arrangement"));
        return ResponseEntity.ok(jsonFactory.toJsonString(new objectRequest(String.valueOf(op),teamWorkService.getStatus(op))));

    }

}
