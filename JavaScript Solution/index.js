const num = [4,4,4,4,3,3,3,2,2,1];
console.log(nth_most_rate(num, 2));

function nth_most_rate(list, n) {

    //Get the list of occurred numbers
    const numbers = [];

    for (let i = 0; i < list.length; i++) {
        if(!numbers.includes(list[i])) {
            numbers.push(list[i]);
        }
    }

    //Link the occured numbers to the amount of occurance
    const occuranceAndNumber = new Map();

    for (let i = 0; i < numbers.length; i++) {
        var count = 0;
        for (let j = 0; j < list.length; j++) {
            if(numbers[i] === list[j]) {
                count++;
            }
        }
        occuranceAndNumber.set(numbers[i], count);
    }

    //Arrange the amount of occurrance in ascending order
    const values = [];

    for (let i = 0; i < numbers.length; i++) {
        values.push(occuranceAndNumber.get(numbers[i]));
    }
    values.sort();

    //Return the number at the required position
    for (let i = 0; i < numbers.length; i++) {
        if(values[n - 1] === occuranceAndNumber.get(numbers[i])) {
            return numbers[i];
        };
    }
    return 0;

}
