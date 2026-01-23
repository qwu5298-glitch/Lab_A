window.onload = function(){
	let clear = document.getElementById("clear");
	let myDrawer = document.getElementById("myDrawer");
	let webSocket = new WebSocket("ws://10.0.101.187:8080/BradWeb/mycenter");
	let isConnect = false;
	
	webSocket.onopen = function(){
		isConnect = true;
		webSocket.send(JSON.stringify({isTeacher:true}));
	}
	webSocket.onmessage = function(event){
	}
	webSocket.onclose = function(){
		isConnect = false;
	}
	webSocket.onerror = function(event){
		console.log("onError:" + event);
	}
	//--------------------------------
	let ctx = myDrawer.getContext("2d");
	let isDrag = false;
	myDrawer.onmousedown = function(e){
		isDrag = true;
		let x = e.offsetX, y = e.offsetY;
		ctx.beginPath();
		ctx.lineWidth = 4;
		ctx.moveTo(x, y);
	}
	myDrawer.onmouseup = function(e){
		isDrag = false;
	}
	myDrawer.onmousemove = function(e){
		if (isDrag){
			let x = e.offsetX, y = e.offsetY;
			ctx.lineTo(x, y);
			ctx.stroke();
		}
	}
}