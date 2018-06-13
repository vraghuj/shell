<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Hello WebSocket</title>
	<link href="/bootstrap.min.css" rel="stylesheet">
	<link href="/main.css" rel="stylesheet">
	<script src="/jquery-2.2.1.min.js"></script>
	<script src="/app.js"></script>
</head>
<noscript><h2 style="color: #ff0000">Seems your browser doesn't support Javascript! Websocket relies on Javascript being
    enabled. Please enable
    Javascript and reload this page!</h2></noscript>
<div id="main-content" class="container">
    <div class="row">
        <div class="col-md-6">
            <form class="form-inline">
                <div class="form-group">
                    <label for="connect">WebSocket connection:</label>
                    <button id="connect" class="btn btn-default" type="submit">Connect</button>
                    <button id="disconnect" class="btn btn-default" type="submit" disabled="disabled">Disconnect
                    </button>
                </div>
            </form>
        </div>
        <div class="col-md-6">
            <form class="form-inline">
                <button id="send" class="btn btn-default" type="submit">Show Latest gaps data</button>
            </form>
        </div> 
    </div>
    <div class="row">
        <div class="col-md-12">
            <table id="conversation" class="table table-striped">
                <thead>
                <tr>
                    <th>Server Time</th>
                </tr>
                </thead>
                <tbody id="greetings">
                </tbody>
            </table>
            <table id="dbData" class="table table-striped">
                <thead>
                <tr>
                    <th>Time</th>
                    <th>Flavor</th>
                    <th>Feed</th>
                    <th>Recv</th>
                    <th>Miss</th>
                    <th>Fill</th>
                </tr>
                </thead>
                <tbody id="data">
                </tbody>
            </table>
        </div>
    </div>
 
</div>
</body>
</html>