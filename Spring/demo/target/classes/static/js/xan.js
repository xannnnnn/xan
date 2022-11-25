function parseCookie() {
    var cookieObj = {};
    var cookieAry = document.cookie.split(';');
    var cookie;
    
    for (var i=0, l=cookieAry.length; i<l; ++i) {
      cookie = jQuery.trim(cookieAry[i]);
      cookie = cookie.split('=');
      cookieObj[cookie[0]] = cookie[1];
    }
    return cookieObj;
}

function getCookieByName(name) {
    var value = parseCookie()[name];
    if (value) {
      value = decodeURIComponent(value);
    }
    return value;
}

function _Post(data, url, callFunc){
  return $.ajax({	
      url: "http://localhost:8080/" + url,
      type: 'POST',
      data:JSON.stringify(data),
      success:function (rsp){ 
        callFunc(rsp)
      },
      dataType: "json",
      contentType: "application/json"
  });
}