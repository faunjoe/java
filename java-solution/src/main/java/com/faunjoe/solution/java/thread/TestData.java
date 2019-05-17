package com.faunjoe.solution.java.thread;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2019-02-02 15:59
 */
class IncomingMovieV64 {
    private int movieId;

    private String nameCN;

    private String coverUrl;

    public long getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(long releaseDate) {
        this.releaseDate = releaseDate;
    }

    private long releaseDate;

    private String genreIds;

    private List<String> editionIds;

    private boolean ticket;

    private boolean video;

    private int wantedCount;

    private String shortComment;

    private boolean mostConcerned;

    private String showType;

    private String actors;

    private String director;

    private String actorShow;

    private String directorShow;

    public IncomingMovieV64() {
    }



    public void setMovieId(final int movieId) {
        this.movieId = movieId;
    }

    public void setNameCN(final String nameCN) {
        this.nameCN = nameCN;
    }

    public void setCoverUrl(final String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public void setGenreIds(final String genreIds) {
        this.genreIds = genreIds;
    }

    public void setEditionIds(final List<String> editionIds) {
        this.editionIds = editionIds;
    }

    public void setTicket(final boolean ticket) {
        this.ticket = ticket;
    }

    public void setVideo(final boolean video) {
        this.video = video;
    }

    public void setWantedCount(final int wantedCount) {
        this.wantedCount = wantedCount;
    }

    public void setShortComment(final String shortComment) {
        this.shortComment = shortComment;
    }

    public void setMostConcerned(final boolean mostConcerned) {
        this.mostConcerned = mostConcerned;
    }

    public void setShowType(final String showType) {
        this.showType = showType;
    }

    public void setActors(final String actors) {
        this.actors = actors;
    }

    public void setDirector(final String director) {
        this.director = director;
    }

    public void setActorShow(final String actorShow) {
        this.actorShow = actorShow;
    }

    public void setDirectorShow(final String directorShow) {
        this.directorShow = directorShow;
    }

    public int getMovieId() {
        return this.movieId;
    }

    public String getNameCN() {
        return this.nameCN;
    }

    public String getCoverUrl() {
        return this.coverUrl;
    }

    public String getGenreIds() {
        return this.genreIds;
    }

    public List<String> getEditionIds() {
        return this.editionIds;
    }

    public boolean isTicket() {
        return this.ticket;
    }

    public boolean isVideo() {
        return this.video;
    }

    public int getWantedCount() {
        return this.wantedCount;
    }

    public String getShortComment() {
        return this.shortComment;
    }

    public boolean isMostConcerned() {
        return this.mostConcerned;
    }

    public String getShowType() {
        return this.showType;
    }

    public String getActors() {
        return this.actors;
    }

    public String getDirector() {
        return this.director;
    }

    public String getActorShow() {
        return this.actorShow;
    }

    public String getDirectorShow() {
        return this.directorShow;
    }
}
