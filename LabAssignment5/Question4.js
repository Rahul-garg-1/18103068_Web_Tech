function isNormalInteger(str) {
    str = str.trim();
    if (!str) {
	    return false;
    }
	str = str.replace(/^0+/, "") || "0";
	var n = Math.floor(Number(str));
	return n !== Infinity && String(n) === str && n >= 0;
}
		
function Tree(n) {
    let finalTree = ' '.repeat(n-1) + '*';
	for(let i=1; i<=n; i++){
	    finalTree = finalTree + '\n' + ' '.repeat(n-i) + '0'.repeat(2*i-1);
	}
	console.log(finalTree);
	if (isNormalInteger(n) === true){
		document.getElementById('result').innerText = finalTree;
	}
	else{
	   	document.getElementById('result').innerText = '';
	   	alert("Please enter valid number...");
   	}
}