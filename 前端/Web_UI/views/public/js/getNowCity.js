	var map; 
		var gpsPoint; 
		var baiduPoint; 
	var gpsAddress; 
	var baiduAddress; 
		var x;
	var y;
		function getLocation() { 
	//根据IP获取城市 
	var myCity = new BMap.LocalCity(); 
	myCity.get(getCityByIP); 
	
	//获取GPS坐标 
	if (navigator.geolocation) { 
	navigator.geolocation.getCurrentPosition(showMap, handleError, { enableHighAccuracy: true, maximumAge: 1000 }); 
	} else { 
	//alert("您的浏览器不支持使用HTML5来获取地理位置服务"); 
	console.log("您的浏览器不支持使用HTML5来获取地理位置服务");
	} 
	} 
	//根据IP获取城市 
	function getCityByIP(rs) { 
	var cityName = rs.name; 
	//alert("根据IP定位您所在的城市为:" + cityName); 
	$("#ip_position").text(cityName);
	} 
	
	function handleError(value) { 
	switch (value.code) { 
	case 1: 
	console.log("位置服务被拒绝");
	// alert("位置服务被拒绝"); 
	break; 
	case 2: 
	console.log("暂时获取不到位置信息");
	// alert("暂时获取不到位置信息"); 
	break; 
	case 3: 
	console.log("获取信息超时");
	// alert("获取信息超时"); 
	break; 
	case 4: 
	console.log("未知错误");
	// alert("未知错误"); 
	break; 
	} 
	} 
	function init() { 
	getLocation(); 
	} 
	window.onload = init; 