     function sendPlayerData(){
        let playerInfo = {

            firstName: document.getElementById('firstName').value,
            lastName: document.getElementById('lastName').value,
            age: document.getElementById('age').value,
            typeOfInjury: document.getElementById('typeOfInjury').value,
            lengthOfInjury: document.getElementById('lengthOfInjury').value,
            timePeriod: document.getElementById('timePeriod').value
    
        };
        JSON.stringify(playerInfo);
        axios.post('http://localhost:8080/player/create', playerInfo)
        .then(function (response){ 

            console.log(response);
        
        })
        .catch(function (error){
    
            console.log(error);


     })
    }     

function sendPositionData(){

    let positionInfo = {
        position: document.getElementById('position').value
    };
    JSON.stringify(positionInfo);
    axios.post('http://localhost:8080/position/create',positionInfo)
    .then(function (response){ 

        console.log(response);
    
    })
    .catch(function (error){

        console.log(error);


 })
}
































































