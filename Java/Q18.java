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
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-validation</artifactId>
    </dependency>
</dependencies>

//ser model
package com.example.demo.model;

import jakarta.validation.constraints.*;

public class User {

    @NotEmpty(message = "Name is required")
    private String name;

    @Email(message = "Enter a valid email")
    @NotEmpty(message = "Email is required")
    private String email;

    @Min(value = 18, message = "Age must be at least 18")
    @Max(value = 60, message = "Age must be at most 60")
    private int age;

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
}

//controller
package com.example.demo.controller;

import com.example.demo.model.User;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("user", new User());
        return "form";
    }

    @PostMapping("/form")
    public String submitForm(@Valid @ModelAttribute("user") User user,
                             BindingResult result) {
        if (result.hasErrors()) {
            return "form";
        }
        return "success";
    }
}

// form.html

<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>User Form</title>
</head>
<body>
<h2>User Registration Form</h2>
<form th:action="@{/form}" th:object="${user}" method="post">
    <p>
        Name: <input type="text" th:field="*{name}"/>
        <span th:if="${#fields.hasErrors('name')}" th:errors="*{name}"></span>
    </p>
    <p>
        Email: <input type="email" th:field="*{email}"/>
        <span th:if="${#fields.hasErrors('email')}" th:errors="*{email}"></span>
    </p>
    <p>
        Age: <input type="number" th:field="*{age}"/>
        <span th:if="${#fields.hasErrors('age')}" th:errors="*{age}"></span>
    </p>
    <button type="submit">Submit</button>
</form>
</body>
</html>


// success.html

<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Success</title>
</head>
<body>
<h2>Form submitted successfully!</h2>
</body>
</html>
