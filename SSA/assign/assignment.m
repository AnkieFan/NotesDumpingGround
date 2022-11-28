function[] = assignment()
    load("dataIndSSA20222023.mat",'ans','dat','dat1','dat_old');

    % Task 1
    % Part a
    dat = visualize(dat);
    
    % Part b
    [seven_number,m,v,s] = DescriptiveStatistic(dat)
    % hypothesis: This data follows a Poisson distribution

    % Task 2
    % Part a
    [k,theta] = MLEgamma(dat1)

    % Part b
    density_histogram(dat1,k,theta)

    % Task 3
    % Part a
    number = generator(100000);

    % Part b
    % H0: generator does not gerate random number
    chisquare(number,100)
    % Since the chisquare value is much larger than significance,
    % We can reject H0, which means this generator does generate random
    % number
end

function[dat] = visualize(dat)
    dat = sort(dat);
    figure(1)
    boxplot(dat)
    figure(2)
    histogram(dat,20)
    sz =size(dat);
    x = linspace(0,sz(1),sz(1));
    figure(3)
    scatter(x,dat)
    %We can see from scatter that there are some outlines:24.9444
    % And the valuse around [20,23] look weird, but they should not be deleted
    % directly
    outline = find(dat>24.9);
    dat(outline(1)) = [];
end

function[seven_number, m, v, s] = DescriptiveStatistic(dat)
    dat = sort(dat);
    sz =size(dat);
    sz = sz(1);
    seven_index = [round(sz*0.02), round(sz*0.09), round(sz*0.25),round(sz*0.50),round(sz*0.75),round(sz*0.75),round(sz*0.91)];
    seven_number = [dat(seven_index)];
    m = mean(dat);
    v = var(dat);
    s = skewness(dat);
end

function [k, theta] = MLEgamma(dat1)
    a = sym('a');
    b = sym('b');
    dat1 = dat1.';
    n = length(dat1);
    l = n*a*log(b)-b*sum(dat1)+(a-1)*sum(log(dat1))-n*log(gamma(a)); %Likelihood function
    Ya = diff(l,a);
    Yb = diff(l,b);
    S = vpasolve([Ya == 0,Yb ==0]);
    k = double(S.a);
    theta = double(S.b);
end

function [] = density_histogram(dat1,k,theta)
    x = 0:1:60;
    f = x.^(k-1).*exp(-x./theta)/(gamma(k)*(theta^k));
    histogram(dat1,20,'Normalization','pdf')
    hold on 
    plot(x,f)
end

function[D] = kstest(dat1)
    data = sort(dat1);
    n = length(data);
    for i = 1:n
        data(i) = data(i)*i/n;
    end
    Dplus = 0;
    Dminus = 0;
end 

function [cdf] = get_cdf(x,k,theta)
a = sym('a');
f = a.^(k-1).*exp(-a./theta)/(gamma(k)*(theta^k));
cdf = integral(f,0,x);
end

function [number] = generator(n)
x1 = [2957,646,3847,947];
number = zeros(1,n);
[x,number(1,1)] = generator_rec(x1);
for i = 1:n
    [x_new,number(1,i)] = generator_rec(x);
    x = x_new;
end
end

function [x, randomZ] = generator_rec(xn)
aj = [34,63,79,19];
mj = [3485,1947,9124,2934];
tj = [71,31,117,161];
x = mod(aj.*xn,mj);
s = sum(tj.*x);
m = cumprod(mj);
randomZ = mod(s,m(4));
end

function [chis] = chisquare(x,bin)
expect = 100000/bin;
[n,] = hist(x);
chis = 0;
for i = 1:length(n)
    chis = chis + ((n(i)-expect)^2/expect);
end
x = chi2inv(0.95,100000)
end