<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register Page</title>
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
            width: 350px;
        }

        h2 {
            text-align: center;
            margin-bottom: 24px;
            color: #333;
        }

        .form-group {
            margin-bottom: 20px;
            position: relative;
            display: flex;
            align-items: center;
            justify-content: space-between;
        }

        label {
            margin-bottom: 0;
            font-weight: 600;
            width: 30%;
        }

        input[type="text"],
        input[type="password"],
        input[type="tel"] {
            width: 65%;
            padding: 10px 15px;
            border: 1px solid #e1e1e1;
            border-radius: 4px;
            box-shadow: 0 4px 6px rgba(50, 50, 93, 0.11);
            transition: all 0.3s ease-in-out;
        }

        input[type="text"]:focus,
        input[type="password"]:focus,
        input[type="tel"]:focus {
            border-color: #007BFF;
            box-shadow: 0 4px 6px rgba(50, 50, 93, 0.37);
            outline: none;
        }

        button {
            width: 100%;
            background-color: #007BFF;
            color: #fff;
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            box-shadow: 0 7px 14px rgba(50, 50, 93, 0.1);
            transition: all 0.3s ease-in-out;
        }

        button:hover {
            background-color: #0056b3;
            transform: translateY(-1px);
            box-shadow: 0 12px 20px rgba(50, 50, 93, 0.27);
        }

        .register-link,
        .login-link {
            margin-top: 20px;
            text-align: center;
        }

        .register-link a,
        .login-link a {
            color: #007BFF;
            text-decoration: none;
            transition: color 0.3s ease-in-out;
        }

        .register-link a:hover,
        .login-link a:hover {
            text-decoration: underline;
            color: #0056b3;
        }

    </style>
</head>
<body>
<div class="login-form">
    <h2>Register</h2>
    <form id="registerForm">
        <div class="form-group">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required>
        </div>
        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>
        </div>
        <div class="form-group">
            <label for="phone">Phone:</label>
            <input type="text" id="phone" name="phone" required>
        </div>
        <button type="button" onclick="submitForm()">Register</button>
        <div class="login-link">
            Already have an account? <a href="http://localhost:8901/login/login_page">Login here</a>
        </div>
    </form>
    <div id="registerResult"></div>
</div>

<!-- Include jQuery -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<!-- JS code -->
<script>
    function submitForm() {
        var username = $("#username").val().trim();
        var password = $("#password").val().trim();
        var phone = $("#phone").val().trim();

        // 判断参数是否为空
        if(!username || !password || !phone) {
            alert("All fields are required!");
            return; // 停止函数执行
        }

        var userData = {
            username: username,
            password: password,
            phone: phone
        };

        $.ajax({
            url: '/login/register_auth',
            type: 'POST',
            dataType: 'json',
            contentType: 'application/json',
            data: JSON.stringify(userData),
            success: function(response) {
                // Handle success response
                $("#registerResult").text("Registered successfully.");
                alert("Registered successfully!");
            },
            error: function(error) {
                // Handle error response
                $("#registerResult").text("Error: " + JSON.stringify(error));
            }
        });
    }
</script>
</body>
</html>
