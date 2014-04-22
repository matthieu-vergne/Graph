package fr.vergne.graph.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import fr.vergne.graph.Arc;
import fr.vergne.graph.Tree;

public class ImmutableTree<VertexType, ArcType extends Arc<? extends VertexType>>
		extends ImmutableGraph<VertexType, ArcType> implements
		Tree<VertexType, ArcType> {

	private final Collection<? extends ArcType> arcs;
	private final VertexType root;

	public ImmutableTree(Collection<? extends ArcType> arcs) {
		super(extractVerticesFrom(arcs), arcs);
		this.arcs = Collections.unmodifiableSet(new HashSet<ArcType>(arcs));
		this.root = checkAndExtractRootFrom(arcs);
	}

	@SuppressWarnings("unchecked")
	public ImmutableTree(VertexType singleNode) {
		super(Arrays.asList(singleNode), Collections.<ArcType> emptyList());
		this.arcs = Collections.emptySet();
		this.root = singleNode;
	}

	private static <VertexType, ArcType extends Arc<? extends VertexType>> Collection<VertexType> extractVerticesFrom(
			Collection<? extends ArcType> arcs) {
		Collection<VertexType> vertices = new HashSet<VertexType>();
		for (Arc<? extends VertexType> arc : arcs) {
			vertices.addAll(arc.getVertices());
		}
		return vertices;
	}

	private VertexType checkAndExtractRootFrom(
			Collection<? extends Arc<? extends VertexType>> arcs) {
		List<Arc<? extends VertexType>> todo = new ArrayList<Arc<? extends VertexType>>(
				arcs);
		Collection<VertexType> alreadyBrowsed = new HashSet<VertexType>();
		Collection<VertexType> roots = new HashSet<VertexType>();
		boolean hasBeenExtended;
		do {
			hasBeenExtended = false;
			Iterator<Arc<? extends VertexType>> iterator = todo.iterator();
			while (iterator.hasNext()) {
				Arc<? extends VertexType> arc = iterator.next();
				if (alreadyBrowsed.containsAll(arc.getVertices())) {
					throw new IllegalArgumentException("The arc " + arc
							+ " appears to close a cycle in " + arcs);
				} else if (!alreadyBrowsed.isEmpty()
						&& Collections.disjoint(alreadyBrowsed,
								arc.getVertices())) {
					// not an arc extending the tree, let it for later
				} else {
					if (roots.isEmpty()) {
						roots.add(arc.getStart());
					} else if (roots.contains(arc.getStop())) {
						roots.remove(arc.getStop());
						roots.add(arc.getStart());
					} else if (alreadyBrowsed.contains(arc.getStart())) {
						// already valid roots
					} else {
						throw new RuntimeException(
								"This case should not happen");
					}
					alreadyBrowsed.addAll(arc.getVertices());// one added
					iterator.remove();
					hasBeenExtended = true;
				}
			}
		} while (hasBeenExtended);

		if (!todo.isEmpty()) {
			throw new IllegalArgumentException(
					"More than a single tree is provided in the arcs " + arcs);
		} else if (roots.size() > 1) {
			throw new IllegalArgumentException("There is more than 1 root: "
					+ roots);
		} else if (roots.size() < 1) {
			return null;
		} else {
			return roots.iterator().next();
		}
	}

	public VertexType getRoot() {
		return root;
	}

	public ChildrenIterator<VertexType> getChildrenOf(VertexType vertex) {
		return new DefaultChildrenIterator<VertexType>(vertex, arcs);
	}

	public static class DefaultChildrenIterator<VertexType> implements
			ChildrenIterator<VertexType> {

		private final Iterator<? extends Arc<? extends VertexType>> arcIterator;
		private final VertexType parent;
		private VertexType nextChild;

		public DefaultChildrenIterator(VertexType parent,
				Collection<? extends Arc<? extends VertexType>> arcs) {
			this.parent = parent;
			this.arcIterator = arcs.iterator();
			lookForNextChild();
		}

		private void lookForNextChild() {
			nextChild = null;
			while (nextChild == null && arcIterator.hasNext()) {
				Arc<? extends VertexType> arc = arcIterator.next();
				if (arc.getStart().equals(parent)) {
					nextChild = arc.getStop();
				} else {
					// irrelevant arc, just ignore
				}
			}
		}

		@Override
		public Iterator<VertexType> iterator() {
			return this;
		}

		@Override
		public boolean hasNext() {
			return nextChild != null;
		}

		@Override
		public VertexType next() {
			VertexType child = nextChild;
			lookForNextChild();
			return child;
		}

		@Override
		public void remove() {
			throw new IllegalStateException("The tree is immutable.");
		}
	}
}
