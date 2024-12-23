 package com.manning.javapersistence.ch12.fetchloadgraph;

import com.manning.javapersistence.ch12.Constants;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@NamedEntityGraphs({
        @NamedEntityGraph(
                name = "BidBidderItem",
                attributeNodes = {
                        @NamedAttributeNode(value = "bidder"),
                        @NamedAttributeNode(value = "item")
                }
        ),
        @NamedEntityGraph(
                name = "BidBidderItemSellerBids",
                attributeNodes = {
                        @NamedAttributeNode(value = "bidder"),
                        @NamedAttributeNode(
                                value = "item",
                                subgraph = "ItemSellerBids"
                        )
                },
                subgraphs = {
                        @NamedSubgraph(
                                name = "ItemSellerBids",
                                attributeNodes = {
                                        @NamedAttributeNode("seller"),
                                        @NamedAttributeNode("bids")
                                })
                }
        )
})
@Entity
public class Bid {

    @Id
    @GeneratedValue(generator = Constants.ID_GENERATOR)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Item item;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private User bidder;

    @NotNull
    private BigDecimal amount;

    public Bid() {
    }

    public Bid(Item item, User bidder, BigDecimal amount) {
        this.item = item;
        this.amount = amount;
        this.bidder = bidder;
    }

    public Long getId() {
        return id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public User getBidder() {
        return bidder;
    }

    public void setBidder(User bidder) {
        this.bidder = bidder;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}