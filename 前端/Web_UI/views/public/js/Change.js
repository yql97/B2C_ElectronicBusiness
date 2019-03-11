/**
*图片轮播
*/
var min = 0;
var max = 5;
function adAutoChange() {
	 if (min == max) {
		 min = 0;
	 } else {
		 min++;
	 }
	 adChange();
}
/**
*
*/
function adChange() {
	 $("#banner a:eq(" + min + ")").show().siblings("a").hide();
	 $("#banner #slide span:eq(" + min + ")").css("background","red").siblings().css("background","#999");
}

$(function () {
	 $("#banner a:not(':first')").hide();
	 $("#slide i:first").css("background","red");
	 setInterval("adAutoChange()", "3000"); 
	 $("#slide i").mousemove(function () {
		 min = $(this).attr("data-index") - 1;
		 console.log(min);
		 adChange();
	 });
});




