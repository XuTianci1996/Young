function setRem() {
    var a = document.documentElement,
        w = a.clientWidth > 750 ? 750 : a.clientWidth;
    // a.style.fontSize = w / 15 + 'px';
    a.setAttribute('style', 'font-size:' + w / 15 + 'px!important');
}
setRem(); 