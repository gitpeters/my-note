function actionToggle(){
    var action = document.querySelector('.action');
    action.classList.toggle('active')
}

let more = document.querySelectorAll(".more");
for(let i =0; i<more.length; i++){
    more[i].addEventListener('click', function(){
        more[i].parentNode.classList.toggle('active');
    })
}

let navbar = document.querySelectorAll(".hamburger");

for(let e=0; e<navbar.length; e++){
    navbar[e].addEventListener('click', function(){
        navbar[e].parentNode.classList.toggle('active');
    })
}


//Search engine
const search = document.getElementById('search');
const notes = document.querySelectorAll(".note");

const noteLists = document.getElementById("note-content");
const noteContent = noteLists.getElementsByTagName("p");

search.addEventListener('keyup', (e)=>{

    const searchValue = search.value.toLowerCase().trim();
    for(var i = 0; i<noteContent.length; i++){
        let match = notes[i].getElementsByTagName("p")[0];

        if(match){
            let textValue = match.textContent || match.innerHTML;
            if(textValue.toLowerCase().indexOf(searchValue)> -1){
                notes[i].style.display = "";
            }else{
                notes[i].style.display = "none";
            }
        }else{
            notes[i].style.display = "none";
        }
    }
})