var name;
function login() {
    user_name = document.getElementById('user_name');
    if (user_name.value!="") {
        menu = document.getElementById('menu');
        name = user_name.value;
        chatArea = document.getElementById('chatArea');
        menu.style.display = "block";
        chatArea.style.display = "block";
        user = document.getElementById('user');
        user.style.display = "none";
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
function message() {
    chatMessage = document.getElementById('chatMessage');
    chatText = document.getElementById('chatText');
    if (chatMessage.value != "") {
        mes = chatMessage.value;
        nes = chatText.value;
        chatText.value = chatText.value + name + ":" + " " + mes + "\n";
        chatMessage.value = '';
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

};
function show() {
    str = document.getElementById('str');
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
    }
    else if (str.innerHTML == "Undo") {
        str.innerHTML = "History";
        chatEdit.style.display = "block";
        chatDelete.style.display = "block";
        chatMessage.style.display = "block";
        chatEnter.style.display = "block";
    }
};
function change() {
    chatMessage = document.getElementById('chatMessage');
    chatText = document.getElementById('chatText');
    chatText.value = nes;
    chatMessage.value = mes;
};