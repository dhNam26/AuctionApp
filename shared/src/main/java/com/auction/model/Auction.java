package main.java.com.auction.model;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Auction {

    private UUID id;
    private Item item;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private AuctionStatus status;
    private BigDecimal currentPrice;
    private UUID leadingBidderId;
    private List<BidRecord> bidHistory;

    public Auction() {
        this.id = UUID.randomUUID();
        this.status = AuctionStatus.OPEN;
        this.currentPrice = BigDecimal.ZERO;
        this.bidHistory = new ArrayList<>();
    }

    public Auction(
            Item item,
            LocalDateTime startTime,
            LocalDateTime endTime,
            AuctionStatus status,
            BigDecimal currentPrice
    ) {
        this.id = UUID.randomUUID();
        this.item = item;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status == null ? AuctionStatus.OPEN : status;
        this.currentPrice = currentPrice == null ? BigDecimal.ZERO : currentPrice;
        this.bidHistory = new ArrayList<>();
    }

    public synchronized void updateStatus() {
        if (this.status == AuctionStatus.PAID || this.status == AuctionStatus.CANCELED) {
            return;
        }

        if (this.startTime == null || this.endTime == null) {
            return;
        }

        LocalDateTime now = LocalDateTime.now();

        if (now.isBefore(this.startTime)) {
            this.status = AuctionStatus.OPEN;
        } else if (!now.isAfter(this.endTime)) {
            this.status = AuctionStatus.RUNNING;
        } else {
            this.status = AuctionStatus.FINISHED;
        }
    }

    public synchronized boolean canAcceptBid() {
        updateStatus();

        if (this.startTime == null || this.endTime == null) {
            return false;
        }

        LocalDateTime now = LocalDateTime.now();

        return this.status == AuctionStatus.RUNNING
                && !now.isBefore(this.startTime)
                && !now.isAfter(this.endTime);
    }

    public synchronized boolean placeBid(UUID bidderId, BigDecimal bidAmount, boolean automatic) {
        if (bidderId == null || bidAmount == null) {
            return false;
        }

        if (bidAmount.compareTo(BigDecimal.ZERO) <= 0) {
            return false;
        }

        if (!canAcceptBid()) {
            return false;
        }

        if (this.currentPrice == null) {
            this.currentPrice = BigDecimal.ZERO;
        }

        if (bidAmount.compareTo(this.currentPrice) <= 0) {
            return false;
        }

        this.currentPrice = bidAmount;
        this.leadingBidderId = bidderId;
        this.bidHistory.add(new BidRecord(
                bidderId,
                LocalDateTime.now(),
                bidAmount,
                automatic
        ));

        return true;
    }

    public synchronized void finishAuction() {
        this.status = AuctionStatus.FINISHED;
    }

    public synchronized void markAsPaid() {
        if (this.status == AuctionStatus.FINISHED) {
            this.status = AuctionStatus.PAID;
        }
    }

    public synchronized void cancelAuction() {
        this.status = AuctionStatus.CANCELED;
    }

    public boolean isOpen() {
        return this.status == AuctionStatus.OPEN;
    }

    public boolean isRunning() {
        return this.status == AuctionStatus.RUNNING;
    }

    public boolean isFinished() {
        return this.status == AuctionStatus.FINISHED;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public AuctionStatus getStatus() {
        return status;
    }

    public void setStatus(AuctionStatus status) {
        this.status = status;
    }

    public BigDecimal getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(BigDecimal currentPrice) {
        this.currentPrice = currentPrice == null ? BigDecimal.ZERO : currentPrice;
    }

    public UUID getLeadingBidderId() {
        return leadingBidderId;
    }

    public void setLeadingBidderId(UUID leadingBidderId) {
        this.leadingBidderId = leadingBidderId;
    }

    public List<BidRecord> getBidHistory() {
        return new ArrayList<>(bidHistory);
    }

    public void setBidHistory(List<BidRecord> bidHistory) {
        if (bidHistory == null) {
            this.bidHistory = new ArrayList<>();
            return;
        }
        this.bidHistory = new ArrayList<>(bidHistory);
    }

    public static class BidRecord {
        private UUID bidderId;
        private LocalDateTime bidTime;
        private BigDecimal bidAmount;
        private boolean automatic;

        public BidRecord() {
        }

        public BidRecord(UUID bidderId, LocalDateTime bidTime, BigDecimal bidAmount, boolean automatic) {
            this.bidderId = bidderId;
            this.bidTime = bidTime;
            this.bidAmount = bidAmount;
            this.automatic = automatic;
        }

        public UUID getBidderId() {
            return bidderId;
        }

        public void setBidderId(UUID bidderId) {
            this.bidderId = bidderId;
        }

        public LocalDateTime getBidTime() {
            return bidTime;
        }

        public void setBidTime(LocalDateTime bidTime) {
            this.bidTime = bidTime;
        }

        public BigDecimal getBidAmount() {
            return bidAmount;
        }

        public void setBidAmount(BigDecimal bidAmount) {
            this.bidAmount = bidAmount;
        }

        public boolean isAutomatic() {
            return automatic;
        }

        public void setAutomatic(boolean automatic) {
            this.automatic = automatic;
        }
    }
}
