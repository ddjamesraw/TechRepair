//Обработка клика на стрелку вправо
$(document).on('click', ".carousel-button-right",function(){ 
	var carusel = $(this).parents('.carousel');
	right_carusel(carusel);
	return false;
});
//Обработка клика на стрелку влево
$(document).on('click',".carousel-button-left",function(){ 
	var carusel = $(this).parents('.carousel');
	left_carusel(carusel);
	return false;
});
//Обработка клика на стрелку вправо
$(document).on('click', ".carousel-button-right2",function(){ 
	var carusel = $(this).parents('.carousel2');
	right_carusel(carusel);
	return false;
});
//Обработка клика на стрелку влево
$(document).on('click',".carousel-button-left2",function(){ 
	var carusel = $(this).parents('.carousel2');
	left_carusel(carusel);
	return false;
});//Обработка клика на стрелку вправо
$(document).on('click', ".carousel-button-right3",function(){ 
	var carusel = $(this).parents('.carousel3');
	right_carusel(carusel);
	return false;
});
//Обработка клика на стрелку влево
$(document).on('click',".carousel-button-left3",function(){ 
	var carusel = $(this).parents('.carousel3');
	left_carusel(carusel);
	return false;
});
$(document).on('click', ".carousel-button-right4",function(){ 
	var carusel = $(this).parents('.carousel4');
	right_carusel(carusel);
	return false;
});
//Обработка клика на стрелку влево
$(document).on('click',".carousel-button-left4",function(){ 
	var carusel = $(this).parents('.carousel4');
	left_carusel(carusel);
	return false;
});
function left_carusel(carusel){
   var block_width = $(carusel).find('.carousel-block').outerWidth();
   $(carusel).find(".carousel-items .carousel-block").eq(-1).clone().prependTo($(carusel).find(".carousel-items")); 
   $(carusel).find(".carousel-items").css({"left":"-"+block_width+"px"}); 
   $(carusel).find(".carousel-items").animate({left: "0px"}, 200); 
   $(carusel).find(".carousel-items .carousel-block").eq(-1).remove(); 
}
function right_carusel(carusel){
   var block_width = $(carusel).find('.carousel-block').outerWidth();
   $(carusel).find(".carousel-items").animate({left: "-"+ block_width +"px"}, 200); 
   setTimeout(function () { 
      $(carusel).find(".carousel-items .carousel-block").eq(0).clone().appendTo($(carusel).find(".carousel-items")); 
      $(carusel).find(".carousel-items .carousel-block").eq(0).remove(); 
      $(carusel).find(".carousel-items").css({"left":"0px"}); 
   }, 300);
}

$(function() {
//Раскомментируйте строку ниже, чтобы включить автоматическую прокрутку карусели
//	auto_right('.carousel:first');
});

// Автоматическая прокрутка
function auto_right(carusel){
	setTimeout(function(){
		right_carusel(carusel);
		auto_right(carusel);
	}, 3000);
}