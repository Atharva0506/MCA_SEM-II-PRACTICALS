// pom.xml

<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-thymeleaf</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
</dependencies>


// UserForm.java

package com.example.demo.model;

public class UserForm {

    private String country;
    private String gender;
    private boolean agreed;

    // Getters and Setters
    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public boolean isAgreed() { return agreed; }
    public void setAgreed(boolean agreed) { this.agreed = agreed; }
}

// FormController.java

package com.example.demo.controller;

import com.example.demo.model.UserForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class FormController {

    @GetMapping("/user-form")
    public String showForm(Model model) {
        model.addAttribute("userForm", new UserForm());

        model.addAttribute("countries", new String[] { "India", "USA", "Canada", "Germany" });
        return "user-form";
    }

    @PostMapping("/user-form")
    public String handleForm(@ModelAttribute UserForm userForm, Model model) {
        model.addAttribute("user", userForm);
        return "confirmation";
    }
}

// user-form.html

<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>User Form</title>
</head>
<body>
<h2>User Details Form</h2>
<form th:action="@{/user-form}" th:object="${userForm}" method="post">

    <p>
        Country:
        <select th:field="*{country}">
            <option value="">-- Select --</option>
            <option th:each="c : ${countries}" th:value="${c}" th:text="${c}"></option>
        </select>
    </p>

    <p>
        Gender:
        <label><input type="radio" th:field="*{gender}" value="Male"/> Male</label>
        <label><input type="radio" th:field="*{gender}" value="Female"/> Female</label>
    </p>

    <p>
        <label><input type="checkbox" th:field="*{agreed}"/> I agree to the terms & conditions</label>
    </p>

    <button type="submit">Submit</button>
</form>
</body>
</html>

// confirmation.html

<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Confirmation</title>
</head>
<body>
<h2>Submitted Information</h2>
<ul>
    <li><strong>Country:</strong> <span th:text="${user.country}"></span></li>
    <li><strong>Gender:</strong> <span th:text="${user.gender}"></span></li>
    <li><strong>Agreed to Terms:</strong> <span th:text="${user.agreed} ? 'Yes' : 'No'"></span></li>
</ul>
</body>
</html>
