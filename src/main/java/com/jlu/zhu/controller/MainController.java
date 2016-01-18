package com.jlu.zhu.controller;


import com.alibaba.fastjson.JSON;
import com.jlu.zhu.entity.UserEntity;
import com.jlu.zhu.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * MainController
 *
 * @author <a href="mailto:zz_xiaozhu@163.com">风袭</a>
 * @version V1.0.0
 * @since 2015-11-22
 */

@Controller
public class MainController {

    private static Logger logger = Logger.getLogger(MainController.class);

    // 自动装配
    @Autowired
    private UserService userService;


    // 首页
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "redirect:/users";
    }

    // 用户管理
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String users(ModelMap modelMap) {
        // 找到user表里的所有记录
        List<UserEntity> userList = userService.getUsers();

        // 将所有记录传递给返回的jsp页面
        modelMap.addAttribute("userList", userList);
        logger.error("chucuol ---->");
        // 返回 pages 目录下的 userManage.vm 页面
        return "userManage";
        //return "uuu";
    }


    // 添加用户 页面
    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    public String addUser() {
        return "addUser";
    }

    // 添加用户 处理
    @RequestMapping(value = "/addUserPost", method = RequestMethod.POST)
    public String addUserPost(@ModelAttribute("userEntity") UserEntity userEntity) {

        // 数据库中添加一个用户
        //userRepository.save(userEntity);

        // 数据库中添加一个用户，并立即刷新
        userService.insertUser(userEntity);

        // 返回重定向 到 /users 请求
        return "redirect:/users";

    }

    // 查看用户详情
    // @PathVariable可以收集url中的变量，需匹配的变量用{}括起来
    // 例如：访问 localhost:8080/showUser/1 ，将匹配 userId = 1
    @RequestMapping(value = "/showUser/{userId}", method = RequestMethod.GET)
    public String showUser(@PathVariable("userId") Integer userId, ModelMap modelMap) {

        // 找到userId所表示的用户
        UserEntity userEntity = userService.getUserById(userId);

        // 传递给请求页面
        modelMap.addAttribute("user", userEntity);
        return "userDetail";
    }


    // 更新用户信息 页面
    @RequestMapping(value = "/updateUser/{userId}", method = RequestMethod.GET)
    public String updateUser(@PathVariable("userId") Integer userId, ModelMap modelMap) {

        // 找到userId所表示的用户
        UserEntity userEntity = userService.getUserById(userId);

        // 传递给请求页面
        modelMap.addAttribute("user", userEntity);
        return "updateUser";
    }

    // 更新用户信息 操作
    @RequestMapping(value = "/updateUserPost", method = RequestMethod.POST)
    public String updateUserPost(@ModelAttribute("userP") UserEntity userEntity) {

        //UserEntity new_userEntity =

        // 更新用户信息
        userService.updateUser(userEntity);
        return "redirect:/users";
    }

    // 删除用户
    @RequestMapping(value = "/deleteUser/{userId}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable("userId") Integer userId) {

        // 删除id为userId的用户
        userService.deleteUser(userId);
        // 立即刷新
        //userRepository.flush();
        return "redirect:/users";
    }


    @RequestMapping(value = "/example", method = RequestMethod.GET)
    public void showUser(HttpServletResponse response) throws IOException {
        response.getWriter().print("<h1>Hello SpringMVC</h1>");
        response.flushBuffer();
    }

    @RequestMapping(value = "/xxx", method = RequestMethod.GET)
    public String showUser() {
        //1.调用BLL层的服务接口
        //2.设置模型数据
        //3.返回逻辑视图名称
        return "xxx";
    }

//    @RequestMapping(value = "/uuu", method = RequestMethod.GET)
//    public String showUser(@RequestParam("id") int id, ModelMap modelMap) {
//        //1.调用BLL层的服务接口
//        UserEntity user = userService.getUserById(id);
//        String string = JSON.toJSONString(user);
//        System.out.println(string);
//
//        //2.设置模型数据
//        modelMap.put("us", user);
//        logger.error("error");
//        //3.返回逻辑视图名称
//        return "uuu";
//    }

    @RequestMapping("/show1")
    public ModelAndView show1(@RequestParam("id") int id) throws Exception {
        UserEntity user = userService.getUserById(id);
        ModelAndView mav = new ModelAndView("/uuu");//通过ModelAndView构造方法可以指定返回的页面名称
        mav.addObject("us", user);
        return mav;
    }

    //以下是几种和页面传值的例子
    @RequestMapping("/getMap")
    public Map<String, UserEntity> getMap(@RequestParam("id") int id,HttpServletResponse response) throws IOException{
        UserEntity user = userService.getUserById(id);
        Map<String, UserEntity> map = new HashMap<String, UserEntity>();
        map.put("key1", user);
        //map.put("key2", "value-2");
        response.getWriter().print("<h1>${key1.firstname} Hello SpringMVC</h1>");
        //response.flushBuffer();
        return map;
    }


    @RequestMapping(value = "/something", method = RequestMethod.GET)
    @ResponseBody
    public String helloWorld()  {
        return "Hello World";
    }

    @RequestMapping("/welcome2")
    public String welcomeHandler1() {
        return "index";
    }

    //返回值是 void  则响应的视图页面对应为访问地址
    @RequestMapping("/welcome3")
    public void welcomeHandler() {}

    @RequestMapping(value = "/uu", method = RequestMethod.GET)
    public String sh2(@RequestParam("id") int id, ModelMap modelMap) {
        //1.调用BLL层的服务接口
        UserEntity user = userService.getUserById(id);
        String string = JSON.toJSONString(user);
        System.out.println(string);

        //2.设置模型数据
        modelMap.put("us", user);
        logger.error("error");
        //3.返回逻辑视图名称
        return "uuu";
    }

    @Controller
    public class LoginController {
        @RequestMapping(value="/validataUser")
        @ResponseBody
        public Map<String,Object> validataUser(@RequestParam("id") int id){
            UserEntity user = userService.getUserById(id);
            String string = JSON.toJSONString(user);
           // logger.info(" validata user : {}","cdsd");
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("code", true);
            return map;
        }
    }

}
