function open_pop_up(box) {
    $("#overlay").show();
    $(box).center_pop_up();
    $(box).show(500);
};
        
function close_pop_up(box) {
    $(box).hide(500);
    $("#overlay").delay(550).hide(1);
};
        
jQuery.fn.center_pop_up = function() {
    this.css('position','absolute'); 
    this.css('top', ($(window).height() - this.height() - 120) / 2+$(window).scrollTop() + 'px'); 
    this.css('left', ($(window).width() - this.width() - 80) / 2+$(window).scrollLeft() + 'px');
};

$(document).ready(function() {
    $('#buttonCancelEnterWindow').click(function() {
        close_pop_up('#enterWindow');
    });
        
    $('#buttonOpenEnterWindow').click(function() {
        open_pop_up('#enterWindow');
    });
    
    $('#buttonCancelExitWindow').click(function() {
        close_pop_up('#exitWindow');
    });
        
    $('#buttonOpenExitWindow').click(function() {
        open_pop_up('#exitWindow');
    });
    
    $('#buttonCancelNewOrderWindow').click(function() {
        close_pop_up('#newOrderWindow');
    });
        
    $('#buttonOpenNewOrderWindow').click(function() {
        open_pop_up('#newOrderWindow');
    });

    $('#buttonCancelGetStatisticWindow').click(function() {
        close_pop_up('#getStatisticWindow');
    });
        
    $('#buttonOpenGetStatisticWindow').click(function() {
        open_pop_up('#getStatisticWindow');
    });
});

$(document).ready(function() {
    $('.comstatus').change(function() {
        $.ajax({
                type: 'GET',
                url: 'Controller?action=checkcomment&id_comment=' + $(this).attr('name'),
                dataType: 'text'
            });
    });
});