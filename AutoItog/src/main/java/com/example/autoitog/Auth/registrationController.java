package com.example.autoitog.Auth;

//Подключения библиотек
import com.example.autoitog.models.Role;
import com.example.autoitog.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class registrationController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    //Переход к страницу
    @GetMapping("/registration")
    private String RegView()
    {
        return "regis";
    }
    //Добаление
    @PostMapping("/registration")
    private String Reg(UserModel userModel, Model model)
    {
        //Поиск по логину
        UserModel user_Model_from_db = userRepository.findByLogin(userModel.getLogin());
        if (user_Model_from_db != null)
        {
            //Вывод ошибки в случае нахождения аккаунта
            model.addAttribute("message", "Пользователь с таким логином уже существует");
            return "regis";
        }

        userModel.setRole(new Role(1, "USER"));
        userModel.setPassword(passwordEncoder.encode(userModel.getPassword()));
        //Сохранение данных в бд
        userRepository.save(userModel);
        //Переход на авторизацию
        return "redirect:/login";
    }
}
