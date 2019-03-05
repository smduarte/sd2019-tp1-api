package microgram.api.java;


import java.util.List;

import microgram.api.Post;

/**
 * 
 * Interface for the service that manages Posts
 * 
 * @author smd
 *
 */
public interface Posts {
		
	/**
	 * Requests a post
	 * @param postId the unique identifier of the requested post.
	 * @return (OK,Post), or NOT_FOUND
	 */
	Result<Post> getPost( String postId ) ;
	
	/**
	 * Stores a new post, generating and returning its unique identifier.
	 * @param post the post to be created
	 * @return (OK, PostId), or (NOT FOUND) if the owner of the post does not exist.
	 */
	Result<String> createPost( Post post );
	
	/**
	 * Deletes a given Post.
	 * @param postId the unique identifier of the post to be deleted
	 * @return (OK,), or NOT_FOUND if postId does not match an existing post
	 */
	Result<Void> deletePost( String postId );
	
	/**
	 * 
	 * 
	 * @param postId
	 * @param userId
	 * @param isLiked
	 * @return
	 */
	Result<Void> like(String postId, String userId, boolean isLiked);

	/**
	 * 
	 * @param postId
	 * @param userId
	 * @return
	 */
	Result<Boolean> isLiked(String postId, String userId);
		
	/**
	 * 
	 * @param userId
	 * @return
	 */
	Result<List<String>> getPosts( String userId);
	
	
	/**
	 * Returns the feed of the profile. The feed is the list of Posts made by those followed by the given profile.
	 * @param userId profile of the requested feed
	 * @return (OK,List<String>), NOT_FOUND if the profile does not exist
	 */
	Result<List<String>> getFeed( String userId);


}
