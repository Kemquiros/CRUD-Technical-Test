//--FUNCTIONS

$(window).on('load', function() { 
    var ck = getCookie("admin");
    if (ck == "1") {
        $("#userRol").text("Admin");
        $("#userImage").attr("src","images/house.png"); 
        $("#login-btn").attr("onClick","logout()");
        $("#login-float").attr("onClick","logout()");
        $("#login-btn-text").text("Sign Out");
        $("#login-float-text").text("Sign Out");
    }else{
        $("#userRol").text("Guest");
        $("#userImage").attr("src","images/user.jpg");
        $("#login-btn").attr("onClick","login()");
        $("#login-float").attr("onClick","login()");
        $("#login-btn-text").text("Sign In");
        $("#login-float-text").text("Sign In");        
    }
    home();
});



function home(){
   $.post("http://localhost:8080/App1/content",
   {
       code: "home"
   },function(text){
        $("#pagename").html("Home");
        $("#main").html(text);
        $(".mdl-card__title").css("background-image", "url('images/dog.png')");
        $("#login-float").show();
   });

}
function clients(){
  
  $("#pagename").html("Clients");
  $("#main").html("");
  $("#login-float").show();
  
    $.ajax({
        url: "http://localhost:8080/App1/client",
        type: 'GET'
    }).then(function(text) {
        $("#main").append(text);
    });
}
function products(){

  $("#pagename").html("Products");
  $("#main").html("pppp");
  $("#login-float").show();
  

}

function login(){
 

    $.post("http://localhost:8080/App1/content",
    {
        code: "login"
    },function(text){
        $("#pagename").html("Login");               
        $("#main").html(text);
        $(".mdl-card__title").css("background-image", "url('images/wolf.png')");
        $("#login-float").hide();
    });
  
  
}
function getLogin(){

  $.post("http://localhost:8080/App1/login",
    {
        user: $("#user").val(),
        pass: $("#pass").val()
    },
    function(responseJson){
        if(responseJson['log']=="ok"){
            $("#userRol").text("Admin");
            $("#userImage").attr("src","images/house.png"); 
            $("#login-btn").attr("onClick","logout()");
            $("#login-float").attr("onClick","logout()");
            $("#login-btn-text").text("Sign Out");
            $("#login-float-text").text("Sign Out");
            home();
        }else{            
            $("#user").val("");
            $("#pass").val("");
        }
    });
}
function logout(){
      $.post("http://localhost:8080/App1/logout",
    {

    },
    function(){});
    $("#userRol").text("Guest");
    $("#userImage").attr("src","images/user.jpg");
    $("#login-btn").attr("onClick","login()");
    $("#login-float").attr("onClick","login()");
    $("#login-btn-text").text("Sign In");
    $("#login-float-text").text("Sign In");
    home();
    
}

function getCookie(cname) {
    var name = cname + "=";
    var ca = document.cookie.split(';');
    for(var i = 0; i <ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0) == ' ') {
            c = c.substring(1);
        }
        if (c.indexOf(name) == 0) {
            return c.substring(name.length, c.length);
        }
    }
    return "";
}

function createRow(o){
    /*$.ajax({
        url: "http://localhost:8080/App1/client",
        id: $('#id1').val(),
        name: $('#id2').val(),
        city: $('#id3').val(),
        type: 'POST'
    }).then(function() {
       clients();
    });   */ 
    
    $.post("http://localhost:8080/App1/client",
    {
        code: "create",
        id: $('#id1').val(),
        name: $('#id2').val(),
        city: $('#id3').val()
    },
    function(){
        clients();
    });
    
}
function deleteRow(o){
    var id = o.parentNode.parentNode.firstChild.innerHTML;
    $.post("http://localhost:8080/App1/client",
    {
        code: "delete",
        id: id
    },
    function(){
        clients();
    });
    /*$.ajax({
        url: 'http://localhost:8080/App2/client/100',
        type: 'DELETE'  
    }).then(function(result) {
        
    });*/
}

function cancelRow(o){
    clients();
}

function editRow(o){
    var vChilds = o.parentNode.parentNode.childNodes;
    //vChilds =vChilds[0].childNodes;
    var id = vChilds[0].innerHTML;
    var name = vChilds[1].innerHTML;
    var city = vChilds[2].innerHTML;
    //Edit name;
    vChilds[1].innerHTML = "<input class='mdl-textfield__input' type='text'  size='8' value='"+name+"'>";
    
    //Edit City
    vChilds[2].innerHTML = "<input class='mdl-textfield__input' type='text'  size='8' value='"+city+"'>";
    
    //Change Buttons
    var code="<button class='mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect' onclick='cancelRow(this)'>";
    code=code+"<i class='material-icons'>replay</i>";
    code=code+"</button>";
    code=code+"<button class='mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect' onclick='updateRow(this)'>";
    code=code+"<i class='material-icons'>send</i>";
    code=code+"</button>";
    vChilds[3].innerHTML = code;
    //o.parentNode.parentNode.removeChild(vChilds[1]);
    //o.parentNode.parentNode.removeChild(vChilds[2]);
    /*$.post("http://localhost:8080/App1/client",
    {
        code: "delete",
        id: id
    },
    function(){
        clients();
    });*/
    /*$.ajax({
        url: 'http://localhost:8080/App2/client/100',
        type: 'PUT'  
    }).then(function(result) {
        
    });*/
}
function updateRow(o){
    var vChilds = o.parentNode.parentNode.childNodes;
    var id = vChilds[0].innerHTML;
    var name = vChilds[1].firstChild.value;
    var city = vChilds[2].firstChild.value;    
    $.post("http://localhost:8080/App1/client",
    {
        code: "update",
        id: id,
        name: name,
        city: city
    },
    function(){
        clients();
    });
}
    






