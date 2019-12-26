package com.jinxiang.user_role_system.controller;


import com.jinxiang.user_role_system.pojo.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
public class LoginController {


//    @RequestMapping("/login")
//    public ResponseEntity<?> Login(String userName, String password, HttpServletRequest request) {
//        //登入逻辑
//        BaseUser user = baseUserServices.selectUserByCode(userName);
//        if (user == null) {
//            return new ResponseEntity<>(1401, false, "用户不存在", null);
//        }
//
//        String passwordMd5 = DigestUtils.md5DigestAsHex(password.getBytes());
//        if (user.getLogin_count() > 5
//                && (user.getLast_login_time().getTime() + 600 * 1000) > Calendar.getInstance().getTime().getTime()) {
//            return new ResponseEntity<>(1401, false, "连续5次登录失败，请稍后10分钟重试！", null);
//        }
//
//        //保存IP
//        String ip = request.getHeader("X-Real-IP");
//        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
//            ip = request.getHeader("X-Forwarded-For");
//            if (ip != null && !ip.isEmpty() && !"unknown".equalsIgnoreCase(ip)) {
//                int index = ip.indexOf(",");
//                if (index != -1) {
//                    ip = ip.substring(0, index);
//                }
//            } else {
//                ip = request.getRemoteAddr();
//            }
//        }
//
//        if (user.getPassword().equals(passwordMd5)) {
//            //登入成功 生成token --- JWT
//
//            //生成JWT token
//            JwtBuilder jwtBuilder = Jwts.builder()
//                    .setIssuer(Issuer)
//                    .claim("username", user.getCode())
//                    .signWith(signatureAlgorithm, SecretKey);
//            String token = jwtBuilder.compact();
//
//
//            //生成clientId
//            String clientId = UUID.randomUUID().toString();
//            clientId = DigestUtils.md5DigestAsHex(clientId.getBytes());
//
//
////            jsonConfig(Date.class, new DateJsonValueProcessor());
//
//            user.setUser_password(null); //密码不能
//            JSONObject contain = new JSONObject();
//            contain.put("Token", token);
//            contain.put("flag", true);
//            contain.put("user", JSONObject.toJSON(user, jsonConfig).toString());
//
//            redisUtils.set(clientId, contain); //只有一个key = ClientId
//
//            //登录成功更新用户信息
//            BaseUser updateUser = new BaseUser();
//            updateUser.setId(user.getId());
//            updateUser.setLast_login_time(new Date());
//            updateUser.setLast_login_ip(ip);
//            updateUser.setLogin_count(0);
//            if (baseUserServices.updateBySelective(updateUser)) {
//                user.setUser_password(null);
//                JSONObject jsonObject = new JSONObject();
//                jsonObject.put("Token", token);
//                jsonObject.put("Client", clientId);
//                jsonObject.put("loginDate", new SimpleDateFormat("yyyy-MM-dd").format(new Date())); //登录日期
//                jsonObject.put("user", JSONObject.toJSON(user, jsonConfig).toString());
//
//                //登录成功信息写入SecurityContext
//                SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(user.getCode(), "",user.getAuthorities()));
//                return new ResponseEntity<>(0, true, "登录成功", jsonObject);
//            } else {
//                return new ResponseEntity<>(1500, false, "用户更新失败", null);
//            }
//
//        } else {
//            //登入失败
//            BaseUser updateUser = new BaseUser();
//            updateUser.setId(user.getId());
//            updateUser.setLast_login_time(new Date());
//            updateUser.setLast_login_ip(ip);
//            updateUser.setLogin_count(user.getLogin_count() + 1);
//            if (baseUserServices.updateBySelective(updateUser)) {
//                return new ResponseEntity<>(1401, false, "密码或用户名错误，登入失败", null);
//            } else {
//                return new ResponseEntity<>(1500, false, "用户更新失败", null);
//            }
//        }
//    }

    @RequestMapping("/noLogin")
    public ResponseEntity<?> noLogin() {
        return new ResponseEntity<>(401, false, "尚未登录", null);
    }

    @RequestMapping("/failedLogin")
    public ResponseEntity<?> failedLogin() {
        return new ResponseEntity<>(401, false, "登录失败", null);
    }

    @RequestMapping("/successLogin")
    public ResponseEntity<?> successLogin() {
        return new ResponseEntity<>(200, false, "登录成功", null);
    }

    @RequestMapping("/successLogout")
    public ResponseEntity<?> successLogout() {
        return new ResponseEntity<>(200, false, "退出登录成功", null);
    }

    @RequestMapping("/test")
    public ResponseEntity<?> test() {
        return new ResponseEntity<>(0, true, "test", null);
    }

    @RequestMapping("/ttt")
    public ResponseEntity<?> ttt() {
        return new ResponseEntity<>(0, true, "ttt", null);
    }

    @RequestMapping("/user")
    public Authentication user() {
        return SecurityContextHolder.getContext().getAuthentication();
    }
}
