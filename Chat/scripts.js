var name;
var taskList = [];
var messageList = [];

function restoreLogin() {
    if (typeof (Storage) == "undefined") {
        alert("error!!");
        return;
    }
    var last_name = localStorage.getItem('name');
    return last_name && JSON.parse(last_name);
}

function login() {
    user_name = document.getElementById('user_name');
    var rest_name = restoreLogin();
    str = "User" + ":" + rest_name;
    taskList.push(str);
    var rest_message = restoreMessage();
    messag = rest_message;
    taskList.push(messag);
    if (user_name.value != "") {
        menu = document.getElementById('menu');
        name = user_name.value;
        chatArea = document.getElementById('chatArea');
        menu.style.display = "block";
        chatArea.style.display = "block";
        user = document.getElementById('user');
        user.style.display = "none";
        str = "User"+":"+name;
        taskList.push(str);
        localStorage.setItem('name', JSON.stringify(name));
        localStorage.setItem('list', JSON.stringify(taskList," ",4));
         }
};

function logout() {
    menu = document.getElementById('menu');
    chatArea = document.getElementById('chatArea');
    chatArea.style.display = "none";
    menu.style.display = "none";
    user = document.getElementById('user');
    user.style.display = "block";
    chatText = document.getElementById('chatText');
    chatText.value = '';

};

function restoreMessage() {
    if (typeof (Storage) == "undefined") {
        alert("error!!");
        return;
    }
    var last_message = localStorage.getItem('message');
    return last_message && JSON.parse(last_message);
}

function message() {
    chatMessage = document.getElementById('chatMessage');
    chatText = document.getElementById('chatText');
    if (chatMessage.value != "") {
        mes = chatMessage.value;
        nes = chatText.value;
        chatText.value = chatText.value + name + ":" + " " + mes + "\n";
        chatMessage.value = '';
        last = chatText.value;
        mes1 = "Message"+" "+name + ":" + " " + mes;
        messageList.push(mes1);
        localStorage.setItem('message', JSON.stringify(messageList, " ", 4));
        taskList.push(mes1);
        localStorage.setItem('list', JSON.stringify(taskList," ",4));
    }
};

function online() {
    stat = document.getElementById('status');
    if (stat.innerHTML == "Online")
    stat.innerHTML = "Offline";
    else if (stat.innerHTML == "Offline")
    stat.innerHTML = "Online";
};

function del(){
    chatDelete = document.getElementById('chatDelete');
    chatText = document.getElementById('chatText');
    if (chatText.value != "")
        chatText.value = nes;
    s = "Message"+" "+ mes+" " +"deleted";
    taskList.push(s);
    localStorage.setItem('list', JSON.stringify(taskList, " ", 4));

};

function show() {
    str = document.getElementById('str');
    chatText = document.getElementById('chatText');
    if (str.innerHTML == "History") {
        str.innerHTML = "Undo";
        chatDelete = document.getElementById('chatDelete');
        chatDelete.style.display = "none";
        chatEdit = document.getElementById('chatEdit');
        chatEdit.style.display = "none";
        chatMessage = document.getElementById('chatMessage');
        chatMessage.style.display = "none";
        chatEnter = document.getElementById('chatEnter');
        chatEnter.style.display = "none";
        chatText = document.getElementById('chatText');
        var item = localStorage.getItem('list');
        chatText.value = item;
    }
    else if (str.innerHTML == "Undo") {
        str.innerHTML = "History";
        chatEdit.style.display = "block";
        chatDelete.style.display = "block";
        chatMessage.style.display = "block";
        chatEnter.style.display = "block";
        chatText.value = last;
    }
};

function change() {
    chatMessage = document.getElementById('chatMessage');
    chatText = document.getElementById('chatText');
    chatText.value = nes;
    chatMessage.value = mes;
    s1 = "Message" + " " + mes + " " + "edited";
    taskList.push(s1);
    localStorage.setItem('list', JSON.stringify(taskList, " ", 4)); 
};
