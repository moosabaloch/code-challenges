### Challenge
Consider a string expression consisting of the characters `<` and `>` only. We consider the string to be balanced if each `<` always appears before (i.e., to the left of) a corresponding `>` character (they do not need to be adjacent). Moreover, each `<` and `>` act as a unique pair of symbols and neither symbol can be considered as part of any other pair of symbols. For example, the strings `<<>>`, `<>`, and `<><>` are all balanced, but the strings `>>`, `<<>`, and `><>< are unbalanced.

To balance a string, we can replace only `>` character with `<>` at most `maxReplacement` times. Given an expression and the value of `maxReplacement`, can you turn an unbalanced string into a balanced one?

An array of `n` strings, expressions, denoting the list of expressions to check.
An array of `n` integers, `maxReplacements`, where `maxReplacements` denotes the maximum number of replacements allowed when attempting to balance expressions.
The function must return an array of integers where each index `i (0 ≤ i < n)` contains a `1` if expressions is balanced or a `0` if it is not.

#### Input Format:
A set of internal unit tests will be on the code with input in the following format.

The first line contains an integer, `n`, denoting the size of expressions.

Each line `i` of the `n` subsequent lines (where `0 ≤ i < n`) contains a string describing expressions.

The next line contains an integer, `m`, denoting the size of `maxReplacements`.

Each line `i` of the `n` subsequent lines (where `0 ≤ i < n`) contains a string describing `maxReplacements`.

##### Constraints
    `1 ≤ n ≤ 102`
    `1 ≤ length(expressionsi) ≤ 105`
    `0 ≤ maxReplacementsi ≤ 105`
##### Output Format:
The function must return an array of integers where each index `i (0 ≤ i < n)` contains a `1` if expressionsi is balanced or a `0` if it is not.

    `Sample Input (0):`
    `2`
    `<>>>`
    `<>>>>`
    `2`
    `2`
    `2`
    `Sample Output (0):`
    `1`
    `0`

Explanation (0):
We process expressions = `["<>>>", "<>>>>"]` and `maxReplacements = [2, 2]` like so:

For string `<>>>` with `maxReplacements = 2`, it becomes balanced after two replacements: `<>>> → <><>> → <><><>`. Because the string was converted in ≤ `maxReplacements` replacements, we store a `1` in index `0` of our return array.
For string `<>>>>` with `maxReplacements` = `2`, becomes balanced after three replacements: `<>>>> → <><>>> → <><><>> → <><><><>`. Because the string was converted in `>` `maxReplacements` replacements, we store a `0` in index `1` of our return array.
We then return the array `[1, 0]` as our answer.

    Sample Input (1):
    2
    <>
    <>><
    2
    1
    0
    Sample Output (1):
    1
    0
Explanation (1):
We process expressions = `["<>", "<>><"]` and `maxReplacements = [1, 0]` like so:

For string `<>` with `maxReplacements = 1`, it is already balanced and needs no replacements. Because the string is balanced in `≤ maxReplacements` replacements, we store a `1` in index `0` of our return array.
For string `<>><` with `maxReplacements = 0`, the string is not balanced. It's impossible to balance the string because it ends in `<` (and we're also restricted to performing `0` replacements), so we store a `0` in index `1` of our return array.
We then return the array `[1, 0]` as our answer.

For example:

    Input	
    2
    <>>>
    <>>>>
    2
    2
    2
    Result
    1
    0
