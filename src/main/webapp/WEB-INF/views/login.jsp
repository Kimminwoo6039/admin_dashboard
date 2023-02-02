<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        * {
            padding: 0;
            margin: 0;
            border: none;
        }

        body {
            align-items: center;
            font-size: 14px;
            font-family: 'Roboto', sans-serif;
        }

        .login-wrapper {
            display: flex;
            margin: auto;
            align-items: center;
            width: 550px;
            height: 100%;
            padding: 40px;
            box-sizing: border-box;
        }

        #login-form > h2 {
            font-size: 32px;
            color: #6A24FE;
            margin-bottom: 20px;
            text-align: center;
        }

        #login-form > input {
            align-items: center;
            width: 100%;
            height: 58px;
            padding: 0 10px;
            box-sizing: border-box;
            margin-bottom: 16px;
            border-radius: 6px;
            background-color: #F8F8F8;
        }

        #login-form > input::placeholder {
            color: #D2D2D2;
        }

        #login-form > input[type="submit"] {
            color: #fff;
            font-size: 16px;
            background-color: #6A24FE;
            margin-top: 20px;
        }

        #login-form > input[type="checkbox"] {
            display: none;
        }

        #login-form > label {
            color: #999999;
        }

        #login-form input[type="checkbox"] + label {
            cursor: pointer;
            padding-left: 26px;
            background-image: url("checkbox.png");
            background-repeat: no-repeat;
            background-size: contain;
        }

        #login-form input[type="checkbox"]:checked + label {
            background-image: url("checkbox-active.png");
            background-repeat: no-repeat;
            background-size: contain;
        }
    </style>
</head>
<body>
<div class="login-wrapper">
    <form method="post" action="서버의url" id="login-form">
        <h2>로 그 인</h2>
        <input type="text" name="userName" placeholder="Email">
        <input type="password" name="userPassword" placeholder="Password">
        <label for="remember-check">
            <input type="checkbox" id="remember-check">아이디 저장하기
        </label>
        <input type="submit" value="로그인">
    </form>
</div>
</body>
</html>
