package com.controller;

import com.Data.Student;
import com.Data1.StudentOccupation;
import com.Request.ArrangementRequest;
import com.Request.JoinTeamRequest;
import com.Data1.JsonFactory;
import com.Request.objectRequest;
import com.RuanxieApplication;
import com.service.StudentService;
import com.service.TeamService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@EnableSwagger2
@CrossOrigin
public class TeamController {
    StudentService studentService;
    TeamService teamService;
    JsonFactory jsonFactory;

    @ApiOperation(value = "学生", notes = "创建团队")
    @PostMapping("/student/team/add")
    public ResponseEntity<String> createTeam(HttpServletRequest request) throws IOException {
        // 检查学生是否已经加入团队
        String studentId = RuanxieApplication.maplog.FindID();
        System.out.println("studentId" + studentId);
        studentService = new StudentService();
        teamService = new TeamService();
        Student student = studentService.Find(studentId);
        System.out.println(student);
        if (student.getTeamID() != -1) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("当前学生已经加入了团队，无法创建新团队");
        }
        com.Data1.Team team = teamService.TeamBuild(student);
        // 获取当前所有团队ID的最大值
        return ResponseEntity.status(HttpStatus.OK).body(jsonFactory.toJsonString(team));
    }

    @ApiOperation(value = "学生", notes = "获取所有团队信息")
    @PostMapping("/student/team/query")
    public ResponseEntity<String> QueryTeam() throws IOException {

        teamService = new TeamService();
        jsonFactory = new JsonFactory();
        List<com.Data.Team> teams = teamService.queryAllTeam();
        return ResponseEntity.ok(jsonFactory.toJsonString(teams));
    }

    @ApiOperation(value = "学生", notes = "加入团队")
    @PostMapping("/student/team/join")
    @ApiImplicitParam
    public ResponseEntity<String> JoinTeam(@ApiParam(value = "加入团队的ID", required = true) @RequestBody() JoinTeamRequest joinTeamRequest,
                                           HttpServletRequest request) throws IOException, NoSuchFieldException, IllegalAccessException {
        System.out.println(joinTeamRequest);
        String studentId = RuanxieApplication.maplog.FindID();
        studentService = new StudentService();
        teamService = new TeamService();
        Student student = studentService.Find(studentId);
        if (student.getTeamID() != -1) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("当前学生已经加入了团队，无法加入新团队");
        }
        if (teamService.joinTeam(joinTeamRequest.getTeamID(), studentId)) {
            return ResponseEntity.ok().body("加入团队成功");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("当前团队已满！");
        }
    }

    @ApiOperation(value = "学生", notes = "获取团队职位信息")
    @PostMapping("/student/team/occupation/query")
    public ResponseEntity<String> QueryStudentOccupation(HttpServletRequest request,HttpServletResponse response) throws IOException {
        studentService = new StudentService();
        teamService = new TeamService();
        jsonFactory = new JsonFactory();
        int TeamID = studentService.Find(RuanxieApplication.maplog.FindID()).getTeamID();
        List<StudentOccupation> studentOccupations = teamService.FindStudentOccupation(TeamID);
        RuanxieApplication.maplog.setMap("TeamID",String.valueOf(TeamID));
        return ResponseEntity.ok(jsonFactory.convertListToJsonString(studentOccupations));
    }

    @ApiOperation(value = "学生", notes = "更新团队职位信息")
    @PostMapping("/student/team/arrangement/update")
    public ResponseEntity<String> UpdateTeamArrangement(@ApiParam(value = "每个职位以及对应ID", required = true) @RequestBody() ArrangementRequest arrangementRequest,
                                                        HttpServletRequest request) throws IOException, NoSuchFieldException, IllegalAccessException {
        teamService = new TeamService();
        jsonFactory = new JsonFactory();
        int status=teamService.updateTeamArrangement(arrangementRequest, RuanxieApplication.maplog.FindTeamID());
        if (status==0) {
            return ResponseEntity.ok(teamService.getStatus(status));
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(teamService.getStatus(status));
        }
    }
    @ApiOperation(value = "学生",notes = "更新团队状态")
    @PostMapping("/student/team/isBuild/update")
    public ResponseEntity<String> UpdateTeamisBuild() throws IOException {
        teamService = new TeamService();
        jsonFactory = new JsonFactory();
        teamService.updateTeamisbuild(RuanxieApplication.maplog.FindTeamID());
        return ResponseEntity.ok(jsonFactory.toJsonString(new objectRequest("1","更改成功")));
    }
}
