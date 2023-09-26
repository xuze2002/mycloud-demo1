<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Page</title>
    <link href="https://fonts.googleapis.com/css2?family=Segoe+UI:wght@400;600&display=swap" rel="stylesheet">
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(45deg, #83a4d4, #b6fbff);
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
            margin: 0;
        }

        .login-form {
            background-color: #ffffff;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 10px 20px rgba(0, 0, 0, 0.2);
            width: 300px;
        }

        h2 {
            text-align: center;
            margin-bottom: 24px;
            color: #333;
        }

        .form-group {
            margin-bottom: 15px;
            position: relative;
        }

        label {
            display: block;
            margin-bottom: 5px;
            font-weight: 600;
        }

        input[type="text"],
        input[type="password"] {
            width: 89%;
            padding: 10px 15px;
            border: 1px solid #e1e1e1;
            border-radius: 4px;
            box-shadow: 0 4px 6px rgba(50, 50, 93, 0.11);
            transition: all 0.3s ease-in-out;
        }

        input[type="text"]:focus,
        input[type="password"]:focus {
            border-color: #007BFF;
            box-shadow: 0 4px 6px rgba(50, 50, 93, 0.37);
            outline: none;
        }

        button {
            width: 99.5%;
            background-color: #007BFF;
            color: #fff;
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            box-shadow: 0 7px 14px rgba(50, 50, 93, 0.1);
            transition: all 0.3s ease-in-out;
            display: flex;
            justify-content: center;
        }

        button:hover {
            background-color: #0056b3;
            transform: translateY(-1px);
            box-shadow: 0 12px 20px rgba(50, 50, 93, 0.27);
        }

        .register-link {
            margin-top: 20px;
            text-align: center;
        }

        .register-link a {
            color: #007BFF;
            text-decoration: none;
            transition: color 0.3s ease-in-out;
        }

        .register-link a:hover {
            text-decoration: underline;
            color: #0056b3;
        }
    </style>

</head>
<body>
<div class="login-form">
    <h2>Login</h2>
    <div class="form-group">
        <#--展示数据库中的 role -->
        <label for="role">Role:</label>
        <select id="role" name="role">
            <#list roles as role>
                <option value="${role.roleName}">${role.roleName}</option>
            </#list>
            <!-- Add more roles as needed -->
        </select>
    </div>
    <form id="loginForm">
        <div class="form-group">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required>
        </div>
        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>
        </div>
        <button type="button" onclick="submitForm()">Login</button>
    </form>
    <div id="loginResult"></div>
    <div class="register-link">
        Don't have an account? <a href="http://localhost:8901/login/register_page">Register here</a>
    </div>
</div>

<!-- Include jQuery -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<!-- JS code -->
<script>
    function submitForm() {
        var userData = {
            username: $("#username").val(),
            password: $("#password").val(),
            role: $("#role").val()
        };

        $.ajax({
            url: '/login/Login_auth',
            type: 'POST',
            dataType: 'json',
            contentType: 'application/json',
            data: JSON.stringify(userData),
            success: function(response) {
                // Check the response (you might need to adjust this based on the structure of your response)
                if (response.code === 200) { // assumng your response has a "status" field
                    alert("Login successfully!");
                    window.location.href = "index.html"; // Redirect to dashboard
                } else {
                    $("#loginResult").text(JSON.stringify(response));
                }
            },
            error: function(error) {
                // Handle error response
                $("#loginResult").text("Error: " + JSON.stringify(error));
            }
        });
    }
</script>
</body>
</html>
