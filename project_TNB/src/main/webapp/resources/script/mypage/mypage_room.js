
function image_add() {

    const file_div = document.createElement("div");
    file_div.className = "file_area";
    file_div.innerHTML = `<input type="file" name="upload">`;
    document.querySelector('.image_area').append(file_div);

}


function image_delete(){
    const image_area = document.querySelector('.image_area');
    let file_length = $('.file_area').length;
    if(file_length<=1){
        alert("최소 1개이상의 이미지를 등록해주세요.");
    }else{
        image_area.removeChild(image_area.lastElementChild);
    }
}


function checkSubmit(){
    let file_check = false;

    let file = document.querySelectorAll('.file_area input');
    for(var i=0; i<file.length; i++){
        //console.log(file[i].value);
        if(file[i].value.trim()==""){
            document.querySelector('.file_err').innerHTML = "모든 이미지를 등록하거나 사용하지않는 파일을 삭제해주세요.";
            file_check = true;
        }else{
            document.querySelector('.file_err').innerHTML = "";
        }
    }
    const max_people = $('select[name=max_people]').val();
    const standard_people = $('select[name=standard_people]').val();


    if(file_check){
        return false;
    }
    return false;
}

function deleteSaveImg(id){
    const image_area = document.querySelector('.image_area');
    document.querySelector('.save_img'+id).remove();
    let save_length = $('.save_area').length;
    console.log(save_length);
    if(save_length==0){
        image_area.removeChild(image_area.firstElementChild);
    }
    let file_length = $('.file_area').length;
    if(file_length<1){
        image_add();
    }
}