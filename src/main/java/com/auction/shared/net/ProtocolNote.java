package com.auction.shared.net;

/**
 * AuctionApp socket protocol.
 *
 * LOGIN:
 * Request payload: LoginRequest
 * Response payload: UserSession
 *
 * REGISTER:
 * Request payload: RegisterRequest
 * Response payload: UserSession
 *
 * LIST_AUCTIONS:
 * Request payload: null
 * Response payload: List<Auction>
 *
 * GET_AUCTION_DETAIL:
 * Request payload: IdRequest
 * Response payload: Auction
 *
 * LIST_MY_AUCTIONS:
 * Request payload: null
 * Response payload: List<Auction>
 *
 * CREATE_AUCTION:
 * Request payload: CreateAuctionRequest
 * Response payload: Auction
 *
 * UPDATE_AUCTION:
 * Request payload: UpdateAuctionRequest
 * Response payload: Auction
 *
 * CANCEL_AUCTION:
 * Request payload: IdRequest
 * Response payload: Auction or Boolean
 *
 * FINISH_AUCTION:
 * Request payload: IdRequest
 * Response payload: Auction
 *
 * PLACE_BID:
 * Request payload: PlaceBidRequest
 * Response payload: Auction or BidTransaction
 *
 * EVENT_AUCTION_UPDATED:
 * Server event payload: Auction
 *
 * EVENT_AUCTION_FINISHED:
 * Server event payload: Auction
 */
public final class ProtocolNote {
    private ProtocolNote() {}
}