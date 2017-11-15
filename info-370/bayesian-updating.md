# Notes

## Bayesian inference
```
plausibility of p after Dnew = ways p can produce Dnew x prior plausibility of p
                               -------------------------------------------------
                                               sum of products
```

```
Computing plausibilities

ways <- c(0,3,8,9,0)
ways/sum(ways)
```

### Assumptions
A conjectured proportion of blue marbles, `p`, is a parameter value. Just a way of indexing possible explanations of the data.

The relative number of ways that a value `p` can produce the data is usually called a likelihood. It is derived by enumerating all the possible data sequences that could have happened and then eliminating those sequences inconsistent with the data.

The prior plausibility of any specific `p` is usually called the prior probability.

The new, updated plausibility of any specific `p` is usually called the posterior probability.

## Bayesian Updating
Each possible proportion may be more or less plausible, given the evidence.

A Bayesian model begins with one set of plausibilities assigned to each of these possibilities. These are the prior plausibilities. Then it updates them in light of the data, to produce the posterior plausibilities.

## Components of the Model
(1) The number of ways each conjecture could produce an observation
(2)	The accumulated number of ways each conjecture could produce the entire data
(3)	The initial plausibility of each conjectured cause of the data

These have a direct analog in conventional probability theory:
(1) A likelihood function
(2) One or more parameters
(3) A prior

### Likelihood
The likelihood is a mathematical formula that specifies the plausibility of the data. What this means is that the likelihood maps each conjecture—such as a proportion of water on the globe—onto the relative number of ways the data could occur, given that possibility.

However you get the likelihood function, the likelihood needs to tell you the probability of any possible observation, for any possible state of the (small) world, such as a proportion of water on a globe.

Example: If the assumptions are (1) every toss is independent of the other tosses and (2) the probability of W is the same on every toss, probability theory provides a unique answer, known as the binomial distribution.

```
dbinom(w, size=n, prob=p)
```

> The count of “water” observations w is distributed binomially, with probability p of “water” on each toss and n tosses in total.

`dbinom` produces the relative number of ways to see the data `w`, given values for `p` and `n`.

Sometimes, likelihoods are written `L(p|w, n)`: the likelihood of `p`, conditional on `w` and `n`.

### Parameters
In the binomial likelihood, these inputs are `p` (the probability of seeing a W), `n` (the sample size), and `w` (the number of W's). One or all may be parameters. In the example, both `n` and `w` are data. This leaves `p` as an unknown parameter. Our Bayesian machine's job is to describe what the data tell us about it.

### Posterior
For every unique combination of data, likelihood, parameters, and prior, there is a unique set of estimates. The resulting estimates—the relative plausibility of different parameter values, conditional on the data—are known as the POSTERIOR DISTRIBUTION. The posterior distribution takes the form of the probability of the parameters, conditional on the data: `Pr(p|n, w)`.

```
Pr(p|w) = Pr(w|p)Pr(p)
          ------------
             Pr(w)

posterior = likelihood x prior
            ------------------
            average likelihood
```

The average likelihood, Pr(w), can be confusing. It is commonly called the “evidence” of the “probability of the data.”

## Grid Approximation
(1) Define the grid. This means you decide how many points to use in estimating the posterior, and then you make a list of the parameter values on the grid.  
(2) Compute the value of the prior at each parameter value on the grid.  
(3) Compute the likelihood at each parameter value.  
(4) Compute the unstandardized posterior at each parameter value, by multiplying the prior by the likelihood.  
(5) Finally, standardize the posterior, by dividing each value by the sum of all values. In the globe tossing context, here's the code to complete all five of these steps:  

```
# define grid
p_grid <- seq(from=0, to=1, length.out=20)

# define prior
prior <- rep(1,20)

# compute likelihood at each value in grid
likelihood <- dbinom(6, size=9, prob=p_grid)

# compute product of likelihood and prior
unstd.posterior <- likelihood * prior

# standardize the posterior, so it sums to 1
posterior <- unstd.posterior/sum(unstd.posterior)

# display posterior distribution
plot(p_grid, posterior, type="b", xlab="probability of water", ylab="posterior probability")
mtext("20 points")
```

