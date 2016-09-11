
function saveLogin(userName, token) {
    if(token != "") {
        setCookie("dico_FB_user_info", token, 7);
        setCookie("dico_user_name", userName, 7);
    } else {
        setCookie("dico_FB_user_info", token, -1);
        setCookie("dico_user_name", userName, -1);
    }
}

function setCookie(cookieName, value, expireDays) {
    var expireDate = new Date();
    expireDate.setDate(expireDate.getDate() + expireDays);

    var cookieValue = escape(value) + ((expireDate==null) ? "" : "; expires=" + expireDate.toGMTString());

    document.cookie = cookieName + "=" + cookieValue;
}

function deleteCookie(cookieName) {
    var expireDate = new Date();
    expireDate.setDate(expireDate.getDate() - 1);
    document.cookie = cookieName = "= " + "; expires=" + expireDate.toGMTString();
}

function getCookieKey(key){
    var cook = document.cookie + ";";
    var idx =  cook.indexOf(key, 0);
    var val = "";
    if(idx != -1)  {
        cook = cook.substring(idx, cook.length);
        begin = cook.indexOf("=", 0) + 1;
        end = cook.indexOf(";", begin);
        val = unescape( cook.substring(begin, end) );
    }
    return val;
}

function getCookie(cookieName) {
    cookieName = cookieName + '=';
    var cookieData = document.cookie;
    var start = cookieData.indexOf(cookieName);
    var cookieValue = '';
    if(start != -1){
        start += cookieName.length;
        var end = cookieData.indexOf(';', start);
        if(end == -1)end = cookieData.length;
        cookieValue = cookieData.substring(start, end);
    }
    return unescape(cookieValue);
}

function isNotLogin() {
    var token = getCookie('dico_FB_user_info');
    if(token == "" || token == null || token == undefined) {
        return true;
    } else {
        return false;
    }
}

function isLogin() {
    var token = getCookie('dico_FB_user_info');
    if(token == "" || token == null || token == undefined) {
        return false;
    } else {
        return true;
    }
}

function getFacebookTocken() {
    return getCookie('dico_FB_user_info');
}

function getUserName() {
    return getCookie('dico_user_name');
}
