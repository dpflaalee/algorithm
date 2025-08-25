document.addEventListener("DOMContentLoaded", ()=>{
    const canvas = document.getElementById("gameCanvas");
    const ctx = canvas.getContext("2d");
    
    function draw(grid, currentBlocks){
        if(!grid || !grid.length) return;
        ctx.clearRect(0, 0, canvas.width, canvas.height);
        for(let y=0; y<grid.length; y++){
            for(let x=0; x<grid[0].length; x++){
                if(grid[y][x] === 1){
                    ctx.fillStyle = "blue";
                    ctx.fillRect(x*30, y*30,30,30);
                }
            }
        }
        if(currentBlocks){
            currentBlocks.forEach(p=>{
                ctx.fillStyle="red"; 
                ctx.fillRect(p.x*30, p.y*30, 30, 30);});
        }
    }
    function update(){
        fetch("/tetris/state")
            .then(res=>res.json())
            .then(data=>{
                draw(data.board, data.current);
                document.getElementById("score").innerText = data.score;
            });
    }
    document.addEventListener("keydown", e =>{
        let direction = null;
        if(e.key === "ArrowLeft") direction ="left";
        if(e.key === "ArrowRight") direction = "right";
        if(e.key === "ArrowDown") direction = "down";
        if(e.key === "ArrowUp") direction = "rotate";
        if(e.key === ""){
            fetch("/tetris/drop", {method: "POST"}); return;
        }
        if(direction){fetch("/tetris/move?direction="+direction, {method:"POST"});}
    });
    setInterval(()=>{update();},200)
    document.getElementById("startBtn").addEventListener("click",()=>{
        fetch("/tetris/spawn", {method:"POST"});
    });
});
