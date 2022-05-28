# Topic 2: Differential equations (for the Exam)

## ODE
All the formula are provided in formula sheet.

## Stability
Simplify the equation to be $w_{i+1} = x*w_i$
e.g.: In Euler's Method: $w_{i+1} = (1+α)w_i$
1. when x is in [0,1]: monotone and stable
2. when x is in (-1,0]: oscillatory and stable
3. when x < -1: unstable
+ Stiff systems: A stiff system contains fast and stable variables, which behave similarly to y˙i = λyi
for λ ≪ 0.

## Multivariable systems (Matlab question in Exam)
1. Define constant in formulas: alpha, beta...
2. Set variables' matrix:
   + if problem provides some variable: define them in y. Grammar e.g.: y = [S;I;E;R]
   + if not: e.g.: θ'' + δθ' + ρ sin(θ) = 0 
     + Define a new variable like w = θ'. Then w' = θ'' = 0 - ρ sin(θ) - δθ' =  0 - ρ sin(θ) - δw
     + `y = [0;w]`
3. Write derivative functions of these variables:
   f = (t,y) [y(0)'; y(1)']
   e.g.: y = [0,w], f(t,y) = y' = [0',w'], θ' = w, w' = 0 - ρ sin(θ) - δθ' =  0 - ρ sin(θ) - δw
        Grammar in matlab: because y = [0,w], y(0) is 0, y(1) is w
        `f = (t,y) [y(1); 0 - ρ sin(y(0)) - δy(1)]`
4. (If provided) initialize:
   e.g.:
   + Initialize `y0 = [pi;1]`
   + Set initial time `t0 = 0` and final time `tf` (not provided in this example)
5. Solve using `ode45(f,[t0,tf],y0)`

## From Exercise2:
+ Bootstrapping multistep methods: For the question requires Adams-Bashforth method but doesn't assign which RK should use: choose the Runge-Kutta method which has the same **local error**. e.g.: 2-stage AB method (local error $O(h^3)$) -> choose Ralston's RK2  (local error $O(h^3)$)