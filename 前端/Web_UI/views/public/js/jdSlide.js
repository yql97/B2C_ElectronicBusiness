(function(c) {
	var b = c.document;
	var d = c.Math;
	var e = b.getElementsByTagName("head")[0];
	var f = function(j, k) {
		var i = b.createElement("script");
		i.type = "text/javascript";
		i.charset = "UTF-8";
		i.async = true;
		i.src = j;
		i.onload = i.onreadystatechange = k;
		b.body.appendChild(i)
	};
	var g = function(i) {
		var j = b.createElement("link");
		j.setAttribute("rel", "stylesheet");
		j.setAttribute("type", "text/css");
		j.setAttribute("href", i);
		b.body.appendChild(j)
	};
	var h = function(k, q, t, u, s) {
		var m = "jsonp_" + d.random();
		m = m.replace(".", "");
		window[m] = function(i) {
			clearTimeout(l);
			window[m] = null;
			o.removeChild(n);
			u(i)
		};
		var l = setTimeout(function() {
			window[m] = null;
			o.removeChild(n);
			s && s()
		}, 5000);
		q[t] = m;
		var r = [];
		for (var p in q) {
			r.push(p + "=" + q[p])
		}
		var j = k + "?" + r.join("&");
		var n = b.createElement("script");
		n.src = j;
		n.type = "text/javascript";
		var o = b.getElementsByTagName("head")[0];
		o.appendChild(n)
	};
	var a = function(i, j) {
		h("//gia.jd.com/slide/v.html", {}, "callback", function(l) {
			var k = l;
			g(k.data.static_servers + k.data.style);
			f(k.data.static_servers + k.data.script, function() {
				new JDJRValidate(i, j)
			})
		})
	};
	c.initJdSlide = a;
	return a
})(typeof window !== "undefined" ? window : this);
