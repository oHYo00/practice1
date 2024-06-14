package com.multi.semi.hje.task.controller;

import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.multi.semi.hje.task.model.dto.TaskDTO;
import com.multi.semi.hje.task.service.TaskService;
import com.multi.semi.hje.user.model.dto.UserDTO;

@SessionAttributes("loginUser")
@Controller
@RequestMapping("/hje/task")
public class TaskController {

	private TaskService taskService;
	private UserDTO loginDTO;

	@Autowired
	public TaskController(TaskService taskService) {
		super();
		this.taskService = taskService;
	}

	@RequestMapping("/list")
	public String taskMain(HttpSession session) {

//		if (session.getAttribute("loginUser") == null) {
//			return "common/loginRedirectPage";
//		} else {
//			return "task/taskMain";
//		}
		return "hje/task/taskMain";
	}

	@PostMapping("/insert")
	public String insertTask(TaskDTO taskDTO, HttpSession session, Model model) {
		UserDTO loginUser = new UserDTO();
		loginUser.setUserId("test11");

		taskDTO.setUserId(loginUser.getUserId());
		taskDTO.setTaskId(UUID.randomUUID().toString());
		String page = "redirect:/hje/task/list";

		try {
			int result = taskService.insertTask(taskDTO);
			if (result < 0) {
				model.addAttribute("msg", "할일 저장 실패");
				throw new Exception();

			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "할일 저장 실패");

		}

		return page;
	}

	@RequestMapping("/taskList")
	public void selectTaskList(HttpSession session, Model model) {
		UserDTO loginUser = new UserDTO();
		loginUser.setUserId("test11");

		try {
			ArrayList<TaskDTO> list = taskService.selectTaskList(loginUser);
			model.addAttribute("list", list);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@PostMapping("/taskComplete")
	public String updateTask(@RequestBody Map<String, String> data, Model model, HttpSession session) {
		UserDTO loginUser = new UserDTO();
		loginUser.setUserId("test11");
		TaskDTO taskDTO = new TaskDTO();
		String complete = data.get("btn").equals("완료") ? "Y" : "N";
		String page = "";
		taskDTO.setComplete(complete);
		taskDTO.setTaskId(data.get("taskId"));

		try {
			ArrayList<TaskDTO> list = taskService.updateTask(taskDTO, loginUser);
			model.addAttribute("list", list);
			page = "hje/task/taskList";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "할일 업데이트 실패");
			page = "redirect:/hje/task/list";
		}

		return page;
	}

	@PostMapping("/taskDelete")
	public String deleteTask(@RequestBody Map<String, String> data, Model model, HttpSession session) {
		UserDTO loginUser = new UserDTO();
		loginUser.setUserId("test11");
		TaskDTO taskDTO = new TaskDTO();
		System.out.println(data.get("btn"));
		String page = "";

		taskDTO.setTaskId(data.get("taskId"));

		try {
			ArrayList<TaskDTO> list = taskService.deleteTask(taskDTO, loginUser);
			page = "hje/task/taskList";

		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "할일 삭제 실패");
			page = "redirect:/hje/task/list";
		}

		return page;
	}

}
