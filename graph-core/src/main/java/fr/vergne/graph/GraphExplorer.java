package fr.vergne.graph;

import java.util.Iterator;

/**
 * A {@link GraphExplorer} provides a set of convenient methods to explore a
 * {@link Hypergraph} (so also a {@link Graph}).
 * 
 * @author Matthieu Vergne <matthieu.vergne@gmail.com>
 * 
 * @param <VertexType>
 * @param <EdgeType>
 */
public interface GraphExplorer<VertexType, EdgeType extends Hyperedge<? extends VertexType>, GraphType extends Hypergraph<VertexType, EdgeType>> {

	/**
	 * 
	 * @return the graph explored
	 */
	public GraphType getGraph();

	/**
	 * This method should return an {@link Iterator} which provides all the
	 * vertices present in the graph exactly once.
	 * 
	 * @return an {@link Iterator} over the vertices of the graph
	 */
	public Iterator<VertexType> verticesIterator();

	/**
	 * This method should return an {@link Iterator} which provides all the
	 * edges present in the graph exactly once.
	 * 
	 * @return an {@link Iterator} over the edges of the graph
	 */
	public Iterator<EdgeType> edgesIterator();

	/**
	 * This method should return an {@link Iterator} which provides all the
	 * edges linking a given vertex exactly once.
	 * 
	 * @param vertex
	 *            the vertex to which recover the edges
	 * @return an {@link Iterator} over the edges on the vertex
	 */
	public Iterator<EdgeType> edgesIterator(VertexType vertex);
}
