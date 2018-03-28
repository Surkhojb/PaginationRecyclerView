package com.example.juanj.paginationrecyclerview.models;

/**
 * Created by juanj on 28/03/2018.
 */
interface Mapper<A extends Object, B extends  Object>{
    A map(B objectVO);
    B inverse(A model);
}
