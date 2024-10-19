<?php get_header(); ?>

<div id="main" class="container">
    <?php
    if (have_posts()) :
        while (have_posts()) : the_post();
    ?>
        <article class="post">
            <h1><?php the_title(); ?></h1>
            <div class="meta">
                Posted on <?php the_time('F j, Y'); ?> by <?php the_author(); ?>
            </div>
            <?php the_content(); ?>
        </article>
    <?php
        endwhile;
    else :
        echo '<p>No content found</p>';
    endif;
    ?>
</div>

<?php get_footer(); ?>