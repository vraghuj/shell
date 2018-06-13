
var ws;var ws1;
function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
        $("#dbData").show();
    }
    else {
        $("#conversation").hide();
        $("#dbData").hide();
    }
    $("#greetings").html("");
    $("#data").html("");
}

function connect() {
	ws = new WebSocket('ws://192.168.195.167:8080/name');
	ws1 = new WebSocket('ws://192.168.195.167:8080/data');
	ws.onmessage = function(data){
		showGreeting(data.data);
	}
	ws1.onmessage = function(data){
		showData(data.data);
	}
	setConnected(true);
}

function disconnect() {
    if (ws != null) {
        ws.close();
    }
    if (ws1 != null) {
        ws1.close();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendName() {
	var data = JSON.stringify({'name': $("#name").val()});
	ws.send(data);
	ws1.send(data);
}

function showGreeting(message) {
    $("#greetings").html("<tr><td> " + message + "</td></tr>");
}

function showData(message) {
	console.log(JSON.stringify(message));
	var gaps = JSON.parse(message);
	//var user = message.split(":")[0];
	//var mail = message.split(":")[1];
	$("#data").html("");
	for (var i = 0; i < gaps.length; i++) { 
		var date = new Date(gaps[i].minute * 1000);
		console.log(date);
		var currDate = (date.getMonth() + 1) + "/" +
	    				date.getDate() + "/" +
					    date.getFullYear() + " " +
					    date.getHours() + ":" +
					    date.getMinutes() + ":" +
					    date.getSeconds();
		$("#data").append("<tr><td> " + currDate+"("+gaps[i].minute + ") </td><td> " + gaps[i].flavor + "</td><td> " 
				+ gaps[i].feed + "</td><td> " + gaps[i].recv + "</td><td> " + gaps[i].miss + "</td><td> " 
				+ gaps[i].fill + "</td></tr>");
	}
    
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#send" ).click(function() { sendName(); });
});

