$(document).ready(function() {
    jQuery(function() {
        $.ajax({
            url : 'http://ajax.googleapis.com/ajax/services/feed/load?v=1.0&num=3&callback=?&q=' + encodeURIComponent('http://it.tut.by/rss'),
            dataType : 'json',
            success : function (data) {
                if (data.responseData.feed && data.responseData.feed.entries) {
                    for(var i = 0; i < data.responseData.feed.entries.length; i++) {
                        e = data.responseData.feed.entries[i];
                        $("#newsittutby").append("<div class=\"container\">" +
                                                    "<div class=\"row-fluid\">" + 
                                                        "<div class=\"span7 well\">" + "<b>" + e.title + "</b><br/><br/>" +
                                                        e.content + "<br/>" + 
                                                        "<i>" + e.publishedDate + "</i><br/>" + 
                                                        "<a href=\"" + e.link + "\" target=\"_blanc\">Подробнее...</a>" +
                                                        "</div>" + 
                                                    "</div>" +
                                                  "</div>");
                    }
                }
            }
        });
    });
});