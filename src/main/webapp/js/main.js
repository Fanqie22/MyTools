window.onload = function() {
	var zan = new Array();
	var z = new Array();
	var zbtn = new Array();
	zan = document.getElementsByName("zanValue");
	z = document.getElementsByName("z");
	zbtn = document.getElementsByName("zan");
	for (var i = 0; i < zan.length; i++) {
		if (zan[i].innerHTML.indexOf("已") != -1) {
			z[i].innerHTML = "赞";
			zbtn[i].disabled = true;
		} else {
			z[i].innerHTML = "赞一下";
		}
	}

}

function zan(th, tidid) {
	th.disabled = true;
	th.innerHTML = "已赞 <i class='glyphicon glyphicon-thumbs-up'> </i>";
	var mail = document.getElementById("usermails");
	var usermail = mail.value;
	// var tidingsid = tidid.tostring();
	// alert(tidid);
	$.ajax({
		url : "zan",
		type : "POST",
		datatype : "text",
		data : {
			"usermail" : usermail,
			"tidingsidd" : tidid
		},
		success : function(data) {
		}
	})
}

function sendTidings() {
	// alert("wwwwwwwwwwwwww");
	var mail = document.getElementById("usermails");
	var name = document.getElementById("usernames");
	var userInput = document.getElementById("areatidings");
	var strValue = userInput.value;
	var usermail = mail.value;
	var username = name.value;
	var span = document.getElementById("tidingsmessage");
	var form = document.getElementById('tidingsform');

	if (strValue == '' || strValue.length == 0 || strValue == null) {
		// alert(usermail + username + strValue);
		span.innerHTML = "动 态 不 能 为 空 哦 !";
		span.style.color = "red";
	} else {
		// alert(usermail + username + strValue + "---->else");
		span.innerHTML = "";
		form.submit();
		// span.style.color = "green";
		// $.ajax({
		// url : "sendTidings",
		// type : "POST",
		// datatype : "text",
		// data : {
		// "usermail" : usermail,
		// "username" : username,
		// "tiding" : strValue
		// },
		// success : function(data) {
		// location.reload(true);
		// }
		// })

	}
}

function sendComments(tidid) {
	alert(tidid);
	var mail = document.getElementById("usermails");
	var name = document.getElementById("usernames");
	var usermail = mail.value;
	var username = name.value;
	var userInput = document.getElementById("mycomment");
	var strValue = userInput.value;
	var form = document.getElementById('commentsform');
	// if (strValue == '' || strValue.length == 0 || strValue == null) {
	// } else {
	alert(strValue);
	// form.submit();
	$.ajax({
		url : "sendComments",
		type : "POST",
		datatype : "text",
		data : {
			"usermail" : usermail,
			"mycomments" : strValue,
			"username" : username,
			"tidingsid" : tidid
		},
		success : function(data) {
			// form.submit();
			location.reload();
		}
	})
}

function gettidid(id) {
	alert(id);
}