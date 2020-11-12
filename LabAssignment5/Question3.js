function validateParenthesis(str) {
    let bracketsStack = [];
    for(let i=0; i<str.length; i++){
        if(str[i]==='(' || str[i]==='[' || str[i]==='{'){
            console.log('pushed ' + str[i]);
            bracketsStack.push(str[i]);
        }
        else if( str[i] === ')'){
            if(bracketsStack.length !== 0 && bracketsStack[bracketsStack.length-1] === '('){
                console.log('Before pop ' + bracketsStack[bracketsStack.length-1]);
                bracketsStack.pop();
                console.log('After pop ' + bracketsStack[bracketsStack.length-1]);
            }
            else {
                console.log('When false ' + bracketsStack[bracketsStack.length-1]);
                return false;
            }
        }
        else if( str[i] === '}'){
            if(bracketsStack.length > 0 && bracketsStack[bracketsStack.length-1] === '{'){
                console.log('Before pop ' + bracketsStack[bracketsStack.length-1]);
                bracketsStack.pop();
                console.log('After pop ' + bracketsStack[bracketsStack.length-1]);
            }
            else {
                console.log('When false ' + bracketsStack[bracketsStack.length-1]);
                return false;
            }
        }
        else if( str[i] === ']'){
            if(bracketsStack.length !== 0 && bracketsStack[bracketsStack.length-1] === '['){
                console.log('Before pop ' + bracketsStack[bracketsStack.length-1]);
                bracketsStack.pop();
                console.log('After pop ' + bracketsStack[bracketsStack.length-1]);
            }
            else {
                console.log('When false ' + bracketsStack[bracketsStack.length-1]);
                return false;
            }
        }
    }
    return bracketsStack.length === 0;
}

function validate(str){
    document.getElementById('result').innerText =
        validateParenthesis(str) === true ? 'The string is valid' : 'The string is invalid' ;
}

function clear() {
    document.getElementById('input').innerText = '';
    document.getElementById('result').innerText = '';
}