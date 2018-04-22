var animation = true;
function  errorAnimation(elem) {




    var $div = document.getElementById('transforms');
    var $formlogin = document.getElementById('forminputs');
    var $forms = document.getElementById('formses');

    //elem.style.visibility = 'hidden';

    $div.style.display = 'block';

    if(animation == true) {
        $div.style.position = 'fixed';
        $div.style.transform = 'translate(-50%,-60%)';
        $div.style.top = '40%';
        $div.style.left = '50%';
        $div.style.width = '90vh';
        $div.style.height = '90vh';

        setInterval(function () {
            $div.style.background = 'white';
            $div.style.width = '80vh';
            $div.style.height = '80vh';
            $div.style.border = '5px solid #212529';
            $div.style.color = 'white';
            setInterval(function () {
                $formlogin.style.zIndex ='100';
                $formlogin.style.opacity = '1';
                setInterval(function () {
                    animation = false;
                }, 500);
            }, 500);
        }, 500);
    }

}


