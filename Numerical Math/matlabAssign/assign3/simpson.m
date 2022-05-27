function int = simpson(a,b,n,F)
h =(b-a)/n;
X = zeros(1,n+1);
for i = 1:n+1
    X(i) = a+(i-1)*h;
end
int = 0;
for i = 1:n
    yi = subs(F,X(i));
    yi2 = subs(F,X(i+1));
    yis = subs(F,(X(i)+X(i+1))/2);
    int = int + (X(i+1)-X(i))*(yi+4*yis+yi2)/6;
end
end
