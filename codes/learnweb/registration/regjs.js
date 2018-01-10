/**
 * Created by Administrator on 2017/12/21.
 */

/* 外部js文件中不能包含<script></script>标签 */
window.onload = function () {
    /* 用户名 */
    var username = document.getElementById("username");
    username.onblur = function () {
        var span = document.querySelector("#username + span");
        if (checkUsername(this.value)) {
            span.innerText = "√";
            span.style.color = "green";
        } else {
            span.innerText = "×";
            span.style.color = "red";
        }
    }

    /* 密码 */
    var password = document.getElementById("password");
    password.onblur = function () {
        var span = document.querySelector("#password + span");
        if (checkPassword(this.value)) {
            span.innerText = "√";
            span.style.color = "green";
        } else {
            span.innerText = "×";
            span.style.color = "red";
        }

    }

    /* 确认密码 */
    var pwconfirm = document.getElementById("confirmPW");
    pwconfirm.onblur = function () {
        var span = document.querySelector("#confirmPW + span");
        if (confirmPassword(this.value, password.value)) {
            span.innerText = "√";
            span.style.color = "green";
        } else {
            span.innerText = "×";
            span.style.color = "red";
        }

    }

    /*  Email */
    var email = document.getElementById("email");
    email.onblur = function () {
        var span = document.querySelector("#email + span");
        if (checkEmail(this.value)) {
            span.innerText = "√";
            span.style.color = "green";
        } else {
            span.innerText = "×";
            span.style.color = "red";
        }

    }

    /* 身份证 */
    var idcard = document.getElementById("idCard");
    idcard.onblur = function () {
        var span = document.querySelector("#idCard + span");
        if (checkIDcard(this.value)) {
            span.innerText = "√";
            span.style.color = "green";
        } else {
            span.innerText = "×";
            span.style.color = "red";
        }

    }

    /* 手机号码 */
    var phone = document.getElementById("phone");
    phone.onblur = function () {
        var span = document.querySelector("#phone + span");
        if (checkPhoneNum(this.value)) {
            span.innerText = "√";
            span.style.color = "green";
        } else {
            span.innerText = "×";
            span.style.color = "red";
        }

    }


    /* 显示省和市 */
    var provinces = ['北京', '上海', '四川', '云南'];
    var citys = [[''], [''], ['成都', '绵阳', '攀枝'],
        ['昆明市', '大理白族自治州', '昭通市']];
    var province = document.getElementById("province");
    province.innerHTML = "";
    province.onchange = function () {
        var index = this.value;
        index = parseInt(index);
        var cityname = citys[index];
        var city = document.getElementById("city");
        city.innerHTML = "";
        for (var i = 0; i < cityname.length; i++) {
            var option = document.createElement("option");
            option.value = i;
            option.innerText = cityname[i];
            city.appendChild(option);
        }
    }
    for (var i = 0; i < provinces.length; i++) {
        var option = document.createElement("option");
        option.value = i;
        option.innerText = provinces[i];
        province.appendChild(option);
    }
}


/* 判断用户名 */
function checkUsername(namestrs) {
    var bool = false;
    if (namestrs) {
        if (noOtherChar(namestrs, '_')) {
            if (checkLength(namestrs, 8, 20)) {
                if (isFirstUpper(namestrs)) {
                    var bool1 = (hasNum(namestrs) && hasLower(namestrs));
                    var bool2 = (hasLower(namestrs) && hasSpecialChar(namestrs, '_'));
                    var bool3 = hasNum(namestrs) && hasSpecialChar(namestrs, '_');
                    if (bool1 || bool2 || bool3) {
                        bool = true;
                    }
                }
            }
        }

    }

    return bool;
}

/* 判断密码 */
function checkPassword(pwstrs) {
    var bool = false;
    if (pwstrs) {
        if (noOtherChar(pwstrs, '_')) {
            if (checkLength(pwstrs, 8, 20)) {
                var bool1 = (hasNum(pwstrs) && hasLower(pwstrs) && hasUpper(pwstrs));
                var bool2 = hasLower(pwstrs) && hasSpecialChar(pwstrs, '_') && hasUpper(pwstrs);
                var bool3 = hasNum(pwstrs) && hasSpecialChar(pwstrs, '_') && hasUpper(pwstrs);
                var bool4 = hasNum(pwstrs) && hasSpecialChar(pwstrs, '_') && asLower(pwstrs);
                if (bool1 || bool2 || bool3 || bool4) {
                    bool = true;
                }
            }
        }
    }

    return bool;
}

/* 确认密码 */
function confirmPassword(pwstrs, password) {
    if (!pwstrs)
        return false;
    if (pwstrs === password)
        return true;
    else
        return false;
}

/* 确认Email地址 */
/*常用邮箱后缀格式
 *@126.com
 @163.com
 @sina.com
 @21cn.com
 @sohu.com
 @yahoo.com.cn
 @tom.com
 @qq.com
 @etang.com
 @eyou.com
 @56.com
 @x.cn
 @chinaren.com
 @sogou.com
 @citiz.com
 */
function checkEmail(emailstrs) {
    var emilbox = [["123.com"], ["163.com"], ["sina.com"], ["sohu.com"], ["gmail.com"], ["qq.com"], ["yahoo.com"], ["sougou.com"], ["21cn.com"]];
    var bool = false;
    if (emailstrs) {
        if (noOtherChar(emailstrs, "_@.")) {
            if (charNum(emailstrs, '@', 1)) {
                var split = emailstrs.split('@', 2);
                var prew = split[0];
                var forword = split[1];
                if (noOtherChar(prew, '_')) {
                    for (var i = 0; i < emilbox.length; i++) {
                        if (forword == emilbox[i]) {
                            bool = true;
                        }
                    }
                }
            }
        }
    }

    return bool;
}

/* 确认身份证 */
function checkIDcard(idstrs) {
    var bool = false;
    if (idstrs) {
        if (checkLength(idstrs, 0, 18)) {
            var id18 = idstrs[17];
            if (isNum(idstrs, 0, 17)) {
                if (isNumc(id18) || id18 == 'x' || id18 == 'X') {
                    bool = true;
                }
            }

        }

    }
    return bool;
}
/* 确认手机号码 */
function checkPhoneNum(phonenums) {
    var bool = false;
    if (phonenums) {
        if (checkLength(phonenums, 0, 11)) {
            if (isNum(phonenums, 0, phonenums.length)) {
                var firstchar = phonenums[0];
                if (firstchar == '1') {
                    var se = phonenums[1];
                    if (se == '3' || se == '4' || se == '5' || se == '7' || se == '8' || se == '9') {
                        bool = true;
                    }
                }
            }
        }
        return bool;
    }
}

/* 长度是否在lenMin到lenMax之间，包含lenMin和lenMax*/
function checkLength(strs, lenMin, lenMax) {
    var len = strs.length;
    if (len >= lenMin && len <= lenMax) {
        return true;
    }
    else {
        return false;
    }
}

/* 是否为空字符串
 * 空返回false；非空返回true；
 *
 function isEmpty(strs) {
 var len = strs.length;
 if (len) {
 return true;
 }
 else {
 return false;
 }
 }

 */
/*  字符串是否为数字 */
function isNum(strs, start, end) {
    if (!start) {
        start = 0;
    }
    if (!end) {
        end = strs.length;
    }
    for (var i = start; i < end; i++) {
        if (isNumc(strs.charAt(i))) {
            return true;
        }
        else {
            return false;
        }
    }

}

/* 是否为大写字母 */
function isUpper(char) {
    if (char >= "A" && char <= 'Z') {
        return true;
    }
    else {
        return false;
    }
}

/* 是否为小写字母 */
function isLower(char) {
    if (char >= "a" && char <= 'z') {
        return true;
    }
    else {
        return false;
    }
}

/* 是否为数字 */
function isNumc(char) {
    if (char >= "0" && char <= '9') {
        return true;
    }
    else {
        return false;
    }
}

/**首字母是否大写
 function isFirstUpper(strs) {
    if (isUpper(strs.charAt(0))) {
        return true;
    }
    else {
        return false;
    }
}
 */
function isFirstUpper(strs) {
    return (isUpper(strs.charAt(0)));
}

/* 有数字吗 */
function hasNum(strs) {
    for (var i = 0; i < strs.length; i++) {
        if (isNumc(strs[i])) {
            return true;
        }
    }
    return false;
}

/* 有大写字母吗 */
function hasUpper(strs) {
    for (var i = 0; i < strs.length; i++) {
        if (isUpper(strs[i])) {
            return true;
        }
    }
    return false;
}

/* 有小写字母吗 */
function hasLower(strs) {
    for (var i = 0; i < strs.length; i++) {
        if (isLower(strs[i])) {
            return true;
        }
    }
    return false;
}

/* 有指定特殊字符吗 */
function hasSpecialChar(strs, char) {
    for (var i = 0; i < strs.length; i++) {
        if (strs[i] == char) {
            return true;
        }
    }
    return false;
}

/* 有数字，字母之外的其他字符吗 */
function noOtherChar(strs, exceptions) {
    var bool = false;

    for (var i = 0; i < strs.length; i++) {
        if (isLower(strs[i]) || isUpper(strs[i]) || isNumc(strs[i]) || search(exceptions, strs[i])) {
            bool = true;
        }
        else {
            return false;
        }
    }

    return bool;
}

/*在字符串中有指定字符*/
function search(strs, char) {
    for (var i = 0; i < strs.length; i++) {
        if (strs[i] == char)
            return true;
    }
    return false;
}

/* 字符串中有指定字符的个数*/
function charNum(strs, char, charnum) {
    var couNum = 0;
    for (var i = 0; i < strs.length; i++) {
        if (strs[i] == char) {
            couNum = couNum + 1;
        }
    }
    if (couNum == charnum) {
        return true;
    }
    else {
        return false;
    }
}