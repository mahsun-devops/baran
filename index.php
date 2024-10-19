<?php get_header(); ?>

<div id="main" class="container">
    <?php
    if (have_posts()) :
        while (have_posts()) : the_post();
    ?>
        <article class="post">
            <h2><a href="<?php the_permalink(); ?>"><?php the_title(); ?></a></h2>
            <div class="meta">
                Posted on <?php the_time('F j, Y'); ?> by <?php the_author(); ?>
            </div>
            <?php the_excerpt(); ?>
            <a href="<?php the_permalink(); ?>" class="read-more">Read More</a>
        </article>
    <?php
        endwhile;
    else :
        echo '<p>No content found</p>';
    endif;
    ?>
</div>

<?php get_footer(); ?>