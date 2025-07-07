
console.log("script loaded");

let currTheme = getTheme();

document.addEventListener('DOMContentLoaded',()=>{
    changeTheme();
})



//TODO
function changeTheme(){
    //set to web page
    document.querySelector('html').classList.add(currTheme);

    //set the listener to change theme button
    const changeThemeButton = document.querySelector('#theme_change_button');

    changeThemeButton.addEventListener('click',()=>{
        console.log("change theme btn is clicked!");
        const oldTheme = currTheme;

        if(currTheme == 'dark') currTheme = 'light';
        else currTheme = 'dark';

        //local storage me update krenge
        setTheme(currTheme);

        //remove the old theme from website
        document.querySelector('html').classList.remove(oldTheme);

        //set the updated theme on website
        document.querySelector('html').classList.add(currTheme);

        //change the text of btn
        changeThemeButton.querySelector('span').textContent = currTheme == "dark"?"Light":"Dark";

    });
    


}

//set Theme to local storage
function setTheme(theme){
    localStorage.setItem("theme",theme);
}

//getTheme from local storage
function getTheme(){
    let theme = localStorage.getItem("theme");
    if(theme) return theme;
    else return "light";

}